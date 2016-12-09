package app.game.action;

import app.game.model.GameModel;
import app.game.model.GameStatus;
import app.game.model.Player;

import java.util.List;

/**
 * Created by james on 11/26/16.
 */
public class StartGame implements Action {

    public static final String NAME = "StartGame";
    private String message;

    String user;
    boolean isHost;

    public StartGame(String user, boolean isHost) {
        this.user = user;
        this.isHost = isHost;
    }

    public boolean isLegal(GameModel model) {
        boolean legal = false;
        List<Player> players = model.getPlayers();
        boolean enoughPlayers = players.size() >= GameModel.MIN_PLAYERS;
        boolean setupPhase = model.getStatus() == GameStatus.SETUP;
        boolean allSet = model.allPlayersSet();

        if (!enoughPlayers) {
            message = "Game doest not yet have minimum players";
        } else if (!setupPhase) {
            message = "Game not in setup phase";
        } else if (!isHost) {
            message = String.format("Only the host can start. %s is not host", user);
        } else if (!allSet) {
            message = String.format("Not all players have selected a token.");
        }

        legal = enoughPlayers && setupPhase && isHost && allSet;
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

    public String toString(Player player) {
        return toString();
    }

    public String getMessage() {
        return message;
    }
}
