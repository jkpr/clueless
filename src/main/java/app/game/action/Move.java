package app.game.action;

import app.exception.GameModelException;
import app.game.model.*;

/**
 * Created by james on 11/26/16.
 */
public class Move implements Action {

    Player player;
    String boardSpace;

    public Move(Player player, String boardSpace) {
        this.player = player;
        this.boardSpace = boardSpace;
    }

    public boolean isLegal(GameModel model) {
        boolean legal = false;
        try {
            boolean activeGame = model.getStatus() == GameStatus.ACTIVE;
            boolean yourTurn = model.getTurn().getWho() == player;
            boolean notMoved = !model.getTurn().getHasMoved();
            BoardSpace origin = player.getCharacter().getSpace();
            BoardSpace destination = model.getBoard().getBoardSpace(boardSpace);
            boolean connected = model.getBoard().isDirectedConnection(origin, destination);
            boolean unoccupied = model.getBoard().getSpaceOccupants(destination).size() == 0;
            boolean hallway = destination.type == GameProperty.HALLWAY;
            boolean open = !hallway || unoccupied;
            legal = activeGame && yourTurn && notMoved && connected && open;
        } catch (GameModelException e) {
            // not legal. stay false
        }
        // TODO: catch NullPointerException (and return false)
        return legal;
    }
    public void apply(GameModel model) {
        try {
            BoardSpace destination = model.getBoard().getBoardSpace(boardSpace);
            player.getCharacter().setSpace(destination);
        } catch (GameModelException e) {

        }// TODO: catch NullPointerException
    }
}
