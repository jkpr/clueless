package app.game.action;

import app.exception.GameModelException;
import app.game.model.*;

/**
 * Created by james on 11/26/16.
 */
/*
5.13.3 Move
After the game has started, players can move their tokens around the board.
 */
public class Move implements Action {

    private String message;

    Player player;
    String boardSpace;

    public Move(Player player, String boardSpace) {
        this.player = player;
        this.boardSpace = boardSpace;
    }

    /*
Operation name: IsLegal(gameState: ClueLessModel): boolean
Description: In order to move, (1) the game status must be “started and in
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
            }

            legal = activeGame && yourTurn && notMoved && connected && open;
        } catch (GameModelException e) {
            // not legal. stay false
            message = String.format("Unrecognized board space: %s", boardSpace);
        }
        // TODO: catch NullPointerException (and return false)
        return legal;
    }
    /*
Operation name: apply(gameState: ClueLessModel)
Description: Sets the Player’s token’s current BoardSpace to the destination
BoardSpace. The Turn’s HasMoved attribute is set to True.
     */
    public void apply(GameModel model) {
        try {
            BoardSpace destination = model.getBoard().getBoardSpace(boardSpace);
            player.getCharacter().setSpace(destination);
            model.getTurn().setHasMoved(true);
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
}
