package app.game;

import app.exception.GameModelException;
import app.game.action.*;
import app.game.model.Character;
import app.game.model.GameModel;
import app.game.model.Player;
import app.json.*;
import app.message.Messaging;
import app.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static app.Application.jsonMapper;

/**
 * Created by james on 11/26/16.
 */
public class Game {
    private static final Logger logger = LoggerFactory.getLogger(Game.class);

    String host;
    GameModel model;

    Map<String, Player> players;

    public Game() {
        host = null;
        model = new GameModel();
        players = new HashMap<>();
    }

    public Game(String user, String characterString) {
        host = user;
        model = new GameModel();
        Player player;
        try {
            Character character = model.getBoard().getCharacter(characterString);
            player = new Player(character);
        } catch (GameModelException e) {
            player = new Player();
        }
        players = new HashMap<>();
        players.put(user, player);
    }

    public boolean isUserPlayer(String user) {
        return players.keySet().contains(user);
    }

    public JsonResponse handleAddPlayer(String username, AddPlayerPayload payload) {
        JsonResponse jsonResponse = new JsonResponse();

        // TODO for the future: some tests for if computer added request
        boolean userAlreadyAdded = players.keySet().contains(username);
        Player player = new Player();
        Action action = new AddPlayer(username, player, userAlreadyAdded);
        boolean legal = action.isLegal(model);
        if (legal) {
            action.apply(model);
            if (players.isEmpty()) {
                host = username;
            }
            players.put(username, player);
            jsonResponse.status = 200;
            jsonResponse.msg = action.toString();
        } else {
            jsonResponse.status = 403;
            jsonResponse.msg = action.getMessage();
        }
        return jsonResponse;

    }

    public JsonResponse handleSetToken(String username, SetTokenPayload payload) {
        JsonResponse jsonResponse = new JsonResponse();

        Action action = new SetToken(username, players.get(username), payload.getWho());
        boolean legal = action.isLegal(model);
        if (legal) {
            action.apply(model);
            jsonResponse.status = 200;
            jsonResponse.msg = action.toString();
        } else {
            jsonResponse.status = 403;
            jsonResponse.msg = action.getMessage();
        }
        return jsonResponse;
    }

    public JsonResponse handleStartGame(String username, StartGamePayload payload) {
        JsonResponse jsonResponse = new JsonResponse();

        Action action = new StartGame(username, players.get(username), username.equals(host));
        boolean legal = action.isLegal(model);
        if (legal) {
            action.apply(model);
            jsonResponse.status = 200;
            jsonResponse.msg = action.toString();
        } else {
            jsonResponse.status = 403;
            jsonResponse.msg = action.getMessage();
        }
        return jsonResponse;
    }

    public JsonResponse handleMove(Player player, MovePayload payload) {
        JsonResponse jsonResponse = new JsonResponse();

        Action action = new Move(player, payload.getTo());
        boolean legal = action.isLegal(model);
        if (legal) {
            action.apply(model);
            jsonResponse.status = 200;
            jsonResponse.msg = action.toString();
        } else {
            jsonResponse.status = 403;
            jsonResponse.msg = action.getMessage();
        }
        return jsonResponse;
    }

    public JsonResponse handleEndTurn(Player player, EndTurnPayload payload) {
        JsonResponse jsonResponse = new JsonResponse();

        Action action = new EndTurn(player);
        boolean legal = action.isLegal(model);
        if (legal) {
            action.apply(model);
            jsonResponse.status = 200;
            jsonResponse.msg = action.toString();
        } else {
            jsonResponse.status = 403;
            jsonResponse.msg = action.getMessage();
        }
        return jsonResponse;
    }

    public JsonResponse handleMakeSuggestion(Player player, MakeSuggestionPayload payload) {
        JsonResponse jsonResponse = new JsonResponse();

        logger.info("Inside Game# handle make suggestion");
        Action action = new MakeSuggestion(player, payload.getCharacter(), payload.getWeapon());
        boolean legal = action.isLegal(model);
        if (legal) {
            action.apply(model);
            jsonResponse.status = 200;
            jsonResponse.msg = action.toString();
        } else {
            jsonResponse.status = 403;
            jsonResponse.msg = action.getMessage();
        }

        return jsonResponse;
    }

    public JsonResponse handleDisproveSuggestion(Player player, DisproveSuggestionPayload payload) {
        JsonResponse jsonResponse = new JsonResponse();

        DisproveSuggestion action = new DisproveSuggestion(player, payload.getCard());
        boolean legal = action.isLegal(model);
        if (legal) {
            action.apply(model);
            jsonResponse.status = 200;
            jsonResponse.msg = action.toString(player);
        } else {
            jsonResponse.status = 403;
            jsonResponse.msg = action.getMessage();
        }

        return jsonResponse;
    }

    public JsonResponse handleMakeAccusation(Player player, MakeAccusationPayload payload) {
        JsonResponse jsonResponse = new JsonResponse();

        Action action = new MakeAccusation(player, payload.getCharacter(), payload.getWeapon(), payload.getRoom());
        boolean legal = action.isLegal(model);
        if (legal) {
            action.apply(model);
            jsonResponse.status = 200;
            jsonResponse.msg = action.getMessage();
        } else {
            jsonResponse.status = 403;
            jsonResponse.msg = action.getMessage();
        }
        return jsonResponse;
    }

    /**
     * Get the game for the user (called by GameController)
     */
    public JSONObject getGameForUser(String user) {
        JSONObject json = new JSONObject();
        Player player = players.get(user);

        try {
            if (player != null) {
                Character character = player.getCharacter();
                if (character != null) {
                    json.put(Messaging.CHARACTER, character.getName());
                    json.put(Messaging.HAND, players.get(user).getHand().stream().map(c -> c.name).collect(Collectors.toList()));
                } else {
                    json.put(Messaging.CHARACTER, "");
                    json.put(Messaging.HAND, new ArrayList<String>());
                }
            } else {
                json.put(Messaging.CHARACTER, "");
                json.put(Messaging.HAND, new ArrayList<String>());
            }

            Action lastAction = model.getHistory().peek();
            if (lastAction != null) {
                json.put(Messaging.NOTIFICATION, lastAction.toString(player));
            } else {
                json.put(Messaging.NOTIFICATION, "");
            }
            json.put(Messaging.BOARD, model.getBoard().toJsonObject());
            json.put(Messaging.STATUS, model.getStatus().toString());
            json.put(Messaging.STATUS_MESSAGE, model.getStatusMessage());
            json.put(Messaging.STATUS_WHO, model.getStatusWho());

            json.put(Messaging.ALL_PLAYERS, model.getAllSetPlayerNames());
            json.put(Messaging.ACTIVE_PLAYERS, model.getAllActivePlayerNames());

            json.put(Messaging.ACTION, model.getAllLegalActionsJson(user, player, user.equals(host)));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }


    public String getBoardForUser(String user) {
        return model.toVisualString();
    }

    public String getVisualModel() {
        List<String> addedUsers = new ArrayList<>();
        for (String username : players.keySet()) {
            addedUsers.add(username);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Users that are playing: ");
        sb.append(String.join(", ", addedUsers));
        if (addedUsers.size() == 0) {
            sb.append("none have joined yet");
        }
        sb.append("\n");
        if (host != null) {
            sb.append("Host is ");
            sb.append(host);
        } else {
            sb.append("The first user to join the game becomes host");
        }
        sb.append("\n<hr/>\n");
        sb.append(model.toVisualString());
        return sb.toString();
    }
}
