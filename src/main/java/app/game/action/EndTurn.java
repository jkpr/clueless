package app.game.action;

import app.exception.GameModelException;
import app.game.model.*;
import app.game.model.GameModel;
import app.game.model.GameProperty;
import app.game.model.Player;

/**
 * Created by james on 11/26/16.
 */

/*
5.13.7 EndTurn
Players often need to end their turn if they do not make an accusation.
 */

public class EndTurn implements Action {

    private String message;

    private Player player;

    public EndTurn(Player player) {
        this.player = player;}


    /*
Operation name: IsLegal(gameState: ClueLessModel): boolean
Description: (1) The game status must be “started and in progress.” (2) It
must be the Player’s token’s turn. (3) The token must have
made a suggestion OR have moved and is in a hallway OR has
no legal move and is unable to make a suggestion. If all of
those conditions hold true, then the operation returns True.
Otherwise, it returns false.
    */

    public boolean isLegal(GameModel model) {
        boolean legal = false;

        //(1)
        boolean activeGame = model.getStatus() == GameStatus.ACTIVE;

        //(2)
        boolean yourTurn = model.getTurn().getWho() == player;

        if (!activeGame) {
            message = "Game not being played";
        } else if (!yourTurn) {
            message = String.format("It is not %s's turn", player.getCharacter().getName());
        }

        //(3)
        boolean madeSuggestion = model.getTurn().getHasSuggested();
        boolean hasMoved = model.getTurn().getHasMoved();
        boolean inHallway = player.getCharacter().getSpace().type == GameProperty.HALLWAY;

        //TODO write getWasMoved method
        //boolean makeSuggestionUnable = !model.getWasMoved().get(player.getCharacter());

        //legal = activeGame && yourTurn && (madeSuggestion || (hasMoved && inHallway));
        legal = activeGame && yourTurn;

        return legal;
    }

    /*
Operation name: Apply(gameState: ClueLessModel)
Description: The turn ends for the requesting player’s token. The token’s
MovedBySuggestion attribute is set to False. The
ClueLessModel call’s the Turn’s NextTurn operation with the
next token in the TurnOrder.
     */
    public void apply(GameModel model) {
        model.getTurn().setMovedBySuggestion(false);
        model.getTurn().nextTurn(player);
        model.endTurn();
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("%s ended his/her turn", player.getCharacter().getName());
    }
}
