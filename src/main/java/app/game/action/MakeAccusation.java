package app.game.action;

import app.exception.GameModelException;
import app.game.model.GameModel;
import app.game.model.GameStatus;
import app.game.model.Player;

/**
 * Created by james on 11/26/16.
 */

/*
5.13.6 MakeAccusation
In order to win the game, players must make a correct accusation. This action is how
making an accusation occurs in the game.
 */

public class MakeAccusation implements Action {

    private String message;
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
    public String getMessage() {
        return message;
    }
    /*
Operation name: IsLegal(gameState: ClueLessModel): boolean
Description: (1) The game status must be “started and in progress.” (2) It
must be the Player’s token’s turn. (3) The token must still be
able to make an accusation legally during the turn. If all of
those conditions hold true, then the operation returns True.
Otherwise, it returns false.
     */
    public boolean isLegal(GameModel model) {
        boolean legal = false;

        boolean activeGame = model.getStatus() == GameStatus.STARTED_IN_PROGRESS;
        boolean yourTurn = model.getTurn().getWho() == player;
        boolean makeAccusation = model.getTurn().getMakeAccustaion();

        legal = activeGame && yourTurn && makeAccusation;

        return legal;
    }

    /*
Operation name: Apply(gameState: ClueLessModel)
Description: The model checks the three cards initialized with the action
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
/*
        if ()
        {
            model.setStatus(GameStatus.FINISHED);
        }
        else
        {

        }
*/
    }
}
