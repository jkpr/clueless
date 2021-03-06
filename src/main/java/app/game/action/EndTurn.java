package app.game.action;

import app.game.model.GameModel;
import app.game.model.GameStatus;
import app.game.model.Player;

/**
 * Created by james on 11/26/16.
 */
public class EndTurn implements Action {
    public static final String NAME = "EndTurn";

    private String message;

    private Player player;

    public EndTurn(Player player) {
        this.player = player;
    }

    public boolean isLegal(GameModel model) {
        boolean legal = false;

        if (player == null) {
            message = "User has not joined the game and thus cannot affect the game.";
            return false;
        } else if (model.getStatus() != GameStatus.ACTIVE && model.getStatus() != GameStatus.ACTIVE_SUGGESTION) {
            message = "Game not being played";
            return false;
        }

        boolean activeGame = model.getStatus() == GameStatus.ACTIVE;
        boolean yourTurn = model.getTurn().getWho() == player;

        if (!activeGame) {
            message = "Game not being played";
        } else if (!yourTurn) {
            message = String.format("It is not %s's turn", player.getCharacter().getName());
        }

        legal = activeGame && yourTurn;
        // TODO add other conditions about forcing a suggestion...
        return legal;
    }


    public void apply(GameModel model) {
        model.endTurn();
        model.getHistory().addHistory(this);
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("%s ended his/her turn", player.getCharacter().getName());
    }

    public String toString(Player player) {
        return toString();
    }
}
