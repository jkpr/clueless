package app;

import app.exception.GameModelException;
import app.game.action.Action;
import app.game.action.Move;
import app.game.model.GameModel;
import app.game.model.Player;
import app.json.GameModelPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by jpringle on 12/4/16.
 */
public class GameModelTest {

    ObjectMapper mapper = new ObjectMapper();

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

    @Test
    public void testPayload() {
        GameModel model = new GameModel();
        try {
            Player p1 = new Player(model.getBoard().getCharacter("Ms. Scarlet"));
            Player p2 = new Player(model.getBoard().getCharacter("Mr. Green"));
            Player p3 = new Player(model.getBoard().getCharacter("Prof. Plum"));
            Player p4 = new Player(model.getBoard().getCharacter("Mrs. White"));
            Player p5 = new Player(model.getBoard().getCharacter("Mrs. Peacock"));
            Player p6 = new Player(model.getBoard().getCharacter("Col. Mustard"));
            model.addPlayer(p1);
            model.addPlayer(p2);
            model.addPlayer(p3);
            model.addPlayer(p4);
            model.addPlayer(p5);
            model.addPlayer(p6);
            model.startGame();
        } catch (GameModelException e) {
            e.printStackTrace();
        }
        GameModelPayload payload = model.toPayload();
        try {
            mapper.writeValue(System.out, payload);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
