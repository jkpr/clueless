package app.game.action;

import app.game.model.GameModel;
import app.game.model.GameStatus;
import app.game.model.Player;

import java.util.List;

/**
 * Created by james on 11/26/16.
 */

/*
5.13.2 StartGame
This ClueLessGame only emits a StartGame Action if the GameHost initiated the
request.
 */

public class StartGame implements Action {

    private String message;

    String user;
    boolean isHost;

    public StartGame(String user, boolean isHost) {
        this.user = user;
        this.isHost = isHost;
    }

    /*
Operation name: IsLegal(gameState: ClueLessModel): boolean
Description: If the game status is “created but not yet started,” and if there
are at least three CharacterTokens set to be controlled by
player, then the operation returns True. Otherwise, it returns
False.
     */
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

    /*
Operation name: Apply(gameState: ClueLessModel)
Description: Switches game status to “started and in progress.”
     */
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
