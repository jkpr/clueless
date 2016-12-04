package app;

import app.exception.GameModelException;
import app.game.action.Action;
import app.game.action.Move;
import app.game.model.GameModel;
import app.game.model.Player;
import org.junit.Test;

/**
 * Created by jpringle on 12/4/16.
 */
public class GameModelTest {

    @Test
    public void testVisualString() {
        GameModel model = new GameModel();

        try {
            Player p1 = new Player(model.getBoard().getCharacter("Ms. Scarlet"));
            Player p2 = new Player(model.getBoard().getCharacter("Mr. Green"));
            Player p3 = new Player(model.getBoard().getCharacter("Prof. Plum"));
            model.addPlayer(p1);
            model.addPlayer(p2);
            model.addPlayer(p3);
            model.startGame();
            System.out.println(model.toVisualString());
            Action a1 = new Move(p1, "Hall-Lounge");
            a1.apply(model);
            System.out.println(model.toVisualString());
        } catch (GameModelException e) {
            e.printStackTrace();
        }
    }
}
