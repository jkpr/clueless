package app.game;

import app.exception.GameModelException;
import app.game.action.*;
import app.game.model.Character;
import app.game.model.GameModel;
import app.game.model.Player;
import app.json.*;
import app.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

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

        Action action = new StartGame(username, username.equals(host));
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
    public String getGameForUser(String user) {
        return model.toVisualString();
    }
}
