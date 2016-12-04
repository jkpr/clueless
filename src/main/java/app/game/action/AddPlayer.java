package app.game.action;

import app.exception.GameModelException;
import app.game.model.Character;
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
    private String tokenName;
    private boolean computerPlayer;

    public AddPlayer(String user, Player player, String tokenName) {
        this.user = user;
        this.tokenName = tokenName;
        computerPlayer = false;
    }

    public AddPlayer(String user, Player player, String tokenName, boolean computerPlayer) {
        this.user = user;
        this.tokenName = tokenName;
        this.computerPlayer = computerPlayer;
    }

    public boolean isLegal(GameModel model) {
        boolean legal = false;
        try {
            Character character = model.getBoard().getCharacter(tokenName);
            boolean tokenFree = true;
            List<Player> players = model.getPlayers();
            for (Player player : players) {
                if (player.getCharacter().equals(character)) {
                    tokenFree = false;
                }
            }
            boolean notMax = players.size() < GameModel.MAX_PLAYERS;
            boolean setupPhase = model.getStatus() == GameStatus.SETUP;

            if (!tokenFree) {
                message = String.format("Token unavailable: %s", tokenName);
            } else if (!notMax) {
                message = "Game already at max players";
            } else if (!setupPhase) {
                message = "Game not in setup phase";
            }

            legal = tokenFree && notMax && setupPhase;
        } catch (GameModelException e) {
            message = String.format("Unrecognized token: %s", tokenName);
        }
        return legal;
    }

    public void apply(GameModel model) {
        try {
            Character character = model.getBoard().getCharacter(tokenName);
            player.setCharacter(character);
            model.addPlayer(player);
            model.getHistory().addHistory(this);
        } catch (GameModelException e) {
            logger.warn("Applying action caused error for: {}", tokenName);
        }
    }

    @Override
    public String toString() {
        if (computerPlayer) {
            return String.format("User %s added computer player to the game as %s", user, tokenName);
        } else {
            return String.format("Added user %s to the game as %s", user, tokenName);
        }
    }

    public String getMessage() {
        return message;
    }
}
