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

    /*
    In order to move, (1) the game status must be “started and in
progress.” (2) It must be the Player’s token’s turn. (3) The token
must still be able to move legally during the turn. (4) The
destination space must be connected to the token’s current
space. (5) If the destination space is a hallway, it must not be
occupied. If all of those conditions hold true, then the
operation returns True. Otherwise, it returns False.
     */
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
    /*
    Sets the Player’s token’s current BoardSpace to the destination
BoardSpace. The Turn’s HasMoved attribute is set to True.
     */
    public void apply(GameModel model) {
        try {
            BoardSpace destination = model.getBoard().getBoardSpace(boardSpace);
            player.getCharacter().setSpace(destination);
        } catch (GameModelException e) {

        }// TODO: catch NullPointerException
    }
}
