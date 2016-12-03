package app.game;

import app.exception.GameModelException;
import app.game.model.Character;
import app.game.model.GameModel;
import app.game.model.Player;
import app.user.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by james on 11/26/16.
 */
public class Game {
    User host;
    GameModel model;

    Map<User, Player> players;

    public Game() {
        host = null;
        model = new GameModel();
        players = new HashMap<>();
    }

    public Game(User user, String characterString) {
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

    public void handleAddPlayer() {

    }

    public void handleSetToken() {

    }

    public void handleStartGame() {

    }

    public void handleMove() {

    }

    public void handEndTurn() {

    }
}
