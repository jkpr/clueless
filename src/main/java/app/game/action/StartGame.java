package app.game.action;

import app.game.model.GameModel;
import app.game.model.GameStatus;
import app.game.model.Player;

import java.util.List;

/**
 * Created by james on 11/26/16.
 */
public class StartGame implements Action {

    private String message;

    String user;

    public StartGame(String user) {
        this.user = user;
    }

    public boolean isLegal(GameModel model) {
        boolean legal = false;
        List<Player> players = model.getPlayers();
        boolean enoughPlayers = players.size() > GameModel.MIN_PLAYERS;
        boolean setupPhase = model.getStatus() == GameStatus.SETUP;

        if (!enoughPlayers) {
            message = "Game doest not yet have minimum players";
        } else if (!setupPhase) {
            message = "Game not in setup phase";
        }

        legal = enoughPlayers && setupPhase;
        return legal;
    }

    public void apply(GameModel model) {
        model.startGame();
        model.getHistory().addHistory(this);
    }

    @Override
    public String toString() {
        return String.format("User %s started the game", user);
    }

    public String getMessage() {
        return message;
    }
}
