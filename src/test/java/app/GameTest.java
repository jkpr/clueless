package app;

import app.game.Game;
import app.json.AddPlayerPayload;
import app.json.MovePayload;
import app.json.SetTokenPayload;
import app.json.StartGamePayload;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by jpringle on 12/7/16.
 */
public class GameTest {

    @Test
    public void testGameString() {
        Game game = new Game();
        JSONObject json = game.getGameForUser("james");
        System.out.println(String.valueOf(json));
        AddPlayerPayload payload1 = new AddPlayerPayload();
        game.handleAddPlayer("james", payload1);

        json = game.getGameForUser("james");
        System.out.println(String.valueOf(json));

        game.handleAddPlayer("federico", payload1);
        game.handleAddPlayer("chris", payload1);

        SetTokenPayload payload2 = new SetTokenPayload();
        payload2.setWho("Ms. Scarlet");

        SetTokenPayload payload3 = new SetTokenPayload();
        payload3.setWho("Mr. Green");

        SetTokenPayload payload4 = new SetTokenPayload();
        payload4.setWho("Prof. Plum");

        game.handleSetToken("james", payload2);

        json = game.getGameForUser("james");
        System.out.println(String.valueOf(json));

        game.handleSetToken("federico", payload3);

        json = game.getGameForUser("james");
        System.out.println(String.valueOf(json));

        game.handleSetToken("chris", payload4);

        json = game.getGameForUser("james");
        System.out.println(String.valueOf(json));

        game.handleStartGame("james", new StartGamePayload());

        json = game.getGameForUser("james");
        System.out.println(String.valueOf(json));
    }

    @Test
    public void testGameJson() {

    }
}
