package app.game.action;

import app.exception.GameModelException;
import app.game.model.GameModel;
import app.game.model.GameStatus;
import app.game.model.Player;

/**
 * Created by james on 11/26/16.
 */
public class DisproveSuggestion implements Action {


    private String message;

    Player player;
    String character;
    String weapon;
    String room;

    public DisproveSuggestion(Player player, String character, String weapon, String room) {
        this.player = player;
        this.character = character;
        this.weapon = weapon;
        this.room = room;
    }

    /*
    (1) The game status must be “disproving suggestion.” (2) The
initiating player must control the character token named in the
turn information stored by the MakeSuggestion action. (3) The
card must belong to the player’s hand. (4) The card must match
one of the suggested cards in the information stored by
MakeSuggestion. If all of those conditions hold true, then the
operation returns True. Otherwise, it returns False.
     */
    public boolean isLegal(GameModel model) {
        boolean legal = false;
        boolean gameStatus = model.getStatus() == GameStatus.DISPROVING_SUGGESTION;

        // stub
        return true;
    }
    /*
    The game status is set to “started and in progress.” The Turn’s
information regarding who can disprove a suggestion and
Note: the which cards were suggested are set to NULL.
     */
    public void apply(GameModel model) {
        model.setStatus(GameStatus.STARTED_IN_PROGRESS);
    }
    public String getMessage() {
        return message;
    }
}
