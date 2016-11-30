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

    private String user;
    private String tokenName;
    private Player player;
    private boolean computerPlayer;

    public AddPlayer(String user, String tokenName) {
        this.user = user;
        this.tokenName = tokenName;
        player = null;
        computerPlayer = false;
    }

    public AddPlayer(String user, String tokenName, boolean computerPlayer) {
        this.user = user;
        this.tokenName = tokenName;
        player = null;
        this.computerPlayer = computerPlayer;
    }

    public boolean isLegal(GameModel model) {
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
            return tokenFree && notMax && setupPhase;
        } catch (GameModelException e) {
            return false;
        }
    }

    public void apply(GameModel model) {
        try {
            Character character = model.getBoard().getCharacter(tokenName);
            player = new Player(character);
            model.addPlayer(player);
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
}
