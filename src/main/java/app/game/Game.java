package app.game;

import app.exception.GameModelException;
import app.game.action.Action;
import app.game.action.AddPlayer;
import app.game.action.SetToken;
import app.game.model.Character;
import app.game.model.GameModel;
import app.game.model.Player;
import app.json.AddPlayerPayload;
import app.json.JsonResponse;
import app.json.SetTokenPayload;
import app.user.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by james on 11/26/16.
 */
public class Game {
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
        // TODO: may be issues with players joining without an assigned character
    }

    public boolean isUserPlayer(String user) {
        return players.keySet().contains(user);
    }

    public JsonResponse handleAddPlayer(String username, AddPlayerPayload payload) {
        JsonResponse jsonResponse = new JsonResponse();

        Player player = new Player();

        Action action = new AddPlayer(username, player, payload.getWho());
        boolean legal = action.isLegal(model);
        if (legal) {
            action.apply(model);
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

    public void handleStartGame() {

    }

    public void handleMove() {

    }

    public void handEndTurn() {

    }
}
