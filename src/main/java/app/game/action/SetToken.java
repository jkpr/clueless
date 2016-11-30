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
 * Created by james on 11/26/16.
 */
public class SetToken implements Action {
    private static final Logger logger = LoggerFactory.getLogger(SetToken.class);

    private String user;
    private Player player;
    private String currentToken;
    private String nextToken;

    public SetToken(String user, Player player, String nextToken) {
        this.user = user;
        this.player = player;
        this.currentToken = player.getCharacter().getName();
        this.nextToken = nextToken;
    }

    public boolean isLegal(GameModel model) {
        try {
            Character character = model.getBoard().getCharacter(nextToken);
            boolean tokenFree = true;
            List<Player> players = model.getPlayers();
            for (Player player : players) {
                if (player.getCharacter().equals(character)) {
                    tokenFree = false;
                }
            }
            boolean setupPhase = model.getStatus() == GameStatus.SETUP;
            return setupPhase && tokenFree;
        } catch (GameModelException e) {
            return false;
        }
    }
    public void apply(GameModel model) {
        try {
            Character character = model.getBoard().getCharacter(nextToken);
            player.setCharacter(character);
        } catch (GameModelException e) {
            logger.warn("Applying action caused error for: {}", nextToken);
        }

    }

    @Override
    public String toString() {
        return String.format("User %s changed tokens to be %s", user, nextToken);
    }
}
