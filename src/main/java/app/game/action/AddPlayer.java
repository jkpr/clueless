package app.game.action;

import app.game.model.GameModel;
import app.game.model.GameStatus;
import app.game.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by jpringle on 11/30/16.
 */
public class AddPlayer implements Action {
    private static final Logger logger = LoggerFactory.getLogger(AddPlayer.class);

    private String message;
    private String user;
    private Player player;
    private boolean userAlreadyAdded;
    private boolean computerPlayer;

    public AddPlayer(String user, Player player, boolean userAlreadyAdded) {
        this.user = user;
        this.player = player;
        this.userAlreadyAdded = userAlreadyAdded;
        computerPlayer = false;
    }

    public AddPlayer(String user, Player player, boolean computerPlayer, boolean userAlreadyAdded) {
        this.user = user;
        this.player = player;
        this.userAlreadyAdded = userAlreadyAdded;
        this.computerPlayer = computerPlayer;
    }

    public boolean isLegal(GameModel model) {
        boolean legal = false;
        List<Player> players = model.getPlayers();
        boolean notMax = players.size() < GameModel.MAX_PLAYERS;
        boolean setupPhase = model.getStatus() == GameStatus.SETUP;

        if (!notMax) {
            message = "Game already at max players";
        } else if (!setupPhase) {
            message = "Game not in setup phase";
        } else if (userAlreadyAdded) {
            message = String.format("User %s has already joined the game", user);
        }

        legal = notMax && setupPhase && !userAlreadyAdded;
        return legal;
    }

    public void apply(GameModel model) {
        model.addPlayer(player);
        model.getHistory().addHistory(this);
    }

    @Override
    public String toString() {
        if (computerPlayer) {
            return String.format("User %s added computer player to the game.", user);
        } else {
            return String.format("Added user %s to the game.", user);
        }
    }

    public String toString(Player player) {
        return toString();
    }

    public String getMessage() {
        return message;
    }
}
