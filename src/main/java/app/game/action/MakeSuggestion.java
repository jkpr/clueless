package app.game.action;
import app.exception.GameModelException;
import app.game.model.*;


/**
 * Created by james on 11/26/16.
 */


public class MakeSuggestion implements Action {

    Player player;
    String character;
    String weapon;
    String room;

    public MakeSuggestion(Player player, String character, String weapon, String room) {
        this.player = player;
        this.character = character;
        this.weapon = weapon;
        this.room = room;
    }

    /*
    (1) The game status must be “started and in progress.” (2) It
    must be the Player’s token’s turn. The token must still be able
    to make a suggestion legally during the turn: (3) the token’s
    MovedBySuggestion is True or the Turn’s HasMoved attribute is
    True and (4) the Turn’s attribute HasSuggested must be False.
    (5) The token must be located in the room that is suggested. If
    all of those conditions hold true, then the operation returns
    True. Otherwise, it returns False.
     */

    public boolean isLegal(GameModel model) {

        boolean legal = false;

        boolean activeGame = model.getStatus() == GameStatus.ACTIVE;
        boolean yourTurn = model.getTurn().getWho() == player;
        boolean makeSuggestion = !model.getTurn().getHasSuggested();
        boolean hasMoved = model.getTurn().getHasMoved();
        boolean movedBySuggestion = model.getTurn().getMovedBySuggestion();
        boolean hasSuggested = model.getTurn().getHasSuggested();
        boolean inSuggestedRoom = player.getCharacter().getSpace().name.equals(room);

        legal = activeGame && yourTurn && makeSuggestion && (movedBySuggestion == true || hasMoved == true) && (hasSuggested == false) && inSuggestedRoom;

        return legal;
    }

/*
    The token corresponding to the suggested suspect is placed in
the room from the suggestion. That token’s
MovedBySuggestion attribute is set to True. The model
determines who can disprove the suggestion starting clockwise
from the player. If someone is found, then the game status is
set to “disproving suggestion” and the suggestion and token
that can disprove the suggestion is temporarily stored. If
someone can disprove or if someone cannot disprove, the turn
information is updated to indicate a suggestion has been made:
HasSuggested is set to True.
*/
    public void apply(GameModel model) {

        model.getTurn().setMovedBySuggestion(true);

    }
}
