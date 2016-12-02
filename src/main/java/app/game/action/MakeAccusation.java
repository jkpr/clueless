package app.game.action;

import app.exception.GameModelException;
import app.game.model.GameModel;
import app.game.model.GameStatus;
import app.game.model.Player;

/**
 * Created by james on 11/26/16.
 */
public class MakeAccusation implements Action {

    Player player;
    String character;
    String weapon;
    String room;

    public MakeAccusation(Player player, String character, String weapon, String room) {
        this.player = player;
        this.character = character;
        this.weapon = weapon;
        this.room = room;
    }
    /*
    n: (1) The game status must be “started and in progress.” (2) It
must be the Player’s token’s turn. (3) The token must still be
able to make an accusation legally during the turn. If all of
those conditions hold true, then the operation returns True.
Otherwise, it returns false.
     */
    public boolean isLegal(GameModel model) {
        boolean legal = false;
        try{
            boolean activeGame = model.getStatus() == GameStatus.STARTED_IN_PROGRESS;
            boolean yourTurn = model.getTurn().getWho() == player;
            boolean makeAccusation = model.getTurn().getMakeAccustaion();

            legal = activeGame && yourTurn && makeAccusation;
        }
        catch (GameModelException e){

        }
        return legal;
    }

    /*
    The model checks the three cards initialized with the action
against the randomly selected room, weapon, and suspect from
the beginning of the game. If all three cards match, then:
- The game ends. The game status is switched to
“completed.” The winner is set to the current character
token.
Else: (the accusation cards do not match the murder cards)
- The initiating player’s token is removed from the turn
order.
- If there are at least two remaining tokens, play
continues. If there is only one remaining token, then the
game ends (game status set to “completed”), and the
sole remaining character token is the winner.
- The current character token’s turn ends.
     */
    public void apply(GameModel model) {
        // stub
    }
}
