package app.game.action;

import app.exception.GameModelException;
import app.game.model.*;

/**
 * Created by james on 11/26/16.
 */
public class Move implements Action {

    public static final String NAME = "Move";

    private String message;

    Player player;
    String boardSpace;

    public Move(Player player, String boardSpace) {
        this.player = player;
        this.boardSpace = boardSpace;
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

        try {
            boolean activeGame = model.getStatus() == GameStatus.ACTIVE;
            boolean yourTurn = model.getTurn().getWho() == player;
            boolean notMoved = !model.getTurn().getHasMoved();
            boolean notSuggested = !model.getTurn().getHasSuggested();
            BoardSpace origin = player.getCharacter().getSpace();
            BoardSpace destination = model.getBoard().getBoardSpace(boardSpace);
            boolean connected = model.getBoard().isDirectedConnection(origin, destination);
            boolean unoccupied = model.getBoard().getSpaceOccupants(destination).size() == 0;
            boolean hallway = destination.type == GameProperty.HALLWAY;
            boolean open = !hallway || unoccupied;

            if (!activeGame) {
                message = "Game not being played";
            } else if (!yourTurn) {
                message = String.format("It is not %s's turn", player.getCharacter().getName());
            } else if (!notMoved) {
                message = String.format("%s has already moved this turn", player.getCharacter().getName());
            } else if (!connected) {
                message = String.format("%s is on board space \"%s\" and it is not connected to board space \"%s\"",
                        player.getCharacter().getName(), player.getCharacter().getSpace().name, boardSpace);
            } else if (!open) {
                message = String.format("Board space %s is not open", boardSpace);
            } else if (!notSuggested) {
                message = String.format("%s has suggested this turn and thus cannot move", player.getCharacter().getName());
            }

            legal = activeGame && yourTurn && notMoved && notSuggested && connected && open;
        } catch (GameModelException e) {
            // not legal. stay false
            message = String.format("Unrecognized board space: %s", boardSpace);
        }
        // TODO: catch NullPointerException (and return false)
        return legal;
    }
    public void apply(GameModel model) {
        try {
            BoardSpace destination = model.getBoard().getBoardSpace(boardSpace);
            player.getCharacter().setSpace(destination);
            model.getTurn().setHasMoved(true);
            model.getHistory().addHistory(this);
        } catch (GameModelException e) {

        }// TODO: catch NullPointerException
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("%s moved to %s", player.getCharacter().getName(), boardSpace);
    }

    public String toString(Player player) {
        return toString();
    }
}
