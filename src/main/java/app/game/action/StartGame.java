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
    Player player;
    boolean isHost;

    public StartGame(String user, Player player, boolean isHost) {
        this.user = user;
        this.player = player;
        this.isHost = isHost;
    }

    public boolean isLegal(GameModel model) {
        boolean legal = false;
        List<Player> players = model.getPlayers();
        boolean enoughPlayers = players.size() >= GameModel.MIN_PLAYERS;
        boolean setupPhase = model.getStatus() == GameStatus.SETUP;
        boolean allSet = model.allPlayersSet();

        if (player == null) {
            message = String.format("%s has not joined the game and thus cannot affect the game.", user);
        } else if (!enoughPlayers) {
            message = "Game doest not yet have minimum players";
        } else if (!setupPhase) {
            message = "Game not in setup phase";
        } else if (!isHost) {
            message = String.format("Only the host can start. %s is not host", user);
        } else if (!allSet) {
            message = "Not all players have selected a token.";
        }

        legal = player != null && enoughPlayers && setupPhase && isHost && allSet;
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
