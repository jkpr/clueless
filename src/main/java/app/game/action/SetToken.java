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

/*
5.13.1 SetToken
Before the game starts, players have the opportunity to choose which character tokens
they would like to control for the game.
 */

public class SetToken implements Action {
    private static final Logger logger = LoggerFactory.getLogger(SetToken.class);

    private String message;

    private String user;
    private Player player;
    private Character currentCharacter;
    private String nextToken;

    public SetToken(String user, Player player, String nextToken) {
        this.user = user;
        this.player = player;
        this.currentCharacter = player.getCharacter();
        this.nextToken = nextToken;
    }

    /*
Operation name: IsLegal(gameState: ClueLessModel): boolean
Description: If the game status is “created but not yet started,” and if the
requested token is not yet controlled by player, then the
operation returns True. Otherwise, it returns False.
     */

    public boolean isLegal(GameModel model) {
        boolean legal = false;
        try {
            Character character = model.getBoard().getCharacter(nextToken);
            boolean tokenFree = true;
            List<Player> players = model.getPlayers();
            for (Player player : players) {
                if (player.controls(character)) {
                    tokenFree = false;
                }
            }
            boolean setupPhase = model.getStatus() == GameStatus.SETUP;

            if (!setupPhase) {
                message = "Game not in setup phase";
            } else if (!tokenFree) {
                message = String.format("Token unavailable: %s", nextToken);
            }
            legal = setupPhase && tokenFree;
            //} catch (GameModelException e) {
        } catch (Exception e) {
            message = String.format("Unrecognized token: %s", nextToken);
        }
        return legal;
    }

    /*
Operation name: Apply(gameState: ClueLessModel)
Description: Sets the token for the originating player to the requested token.
     */
    public void apply(GameModel model) {
        try {
            Character character = model.getBoard().getCharacter(nextToken);
            player.setCharacter(character);
            model.getHistory().addHistory(this);
        } catch (GameModelException e) {
            logger.warn("Applying action caused error for: {}", nextToken);
        }

    }

    @Override
    public String toString() {
        return String.format("User %s changed tokens to be %s", user, nextToken);
    }

    public String getMessage() {
        return message;
    }
}
