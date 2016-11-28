package app;

import app.exception.GameModelException;
import app.game.model.Board;
import app.json.BoardPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static app.game.model.BoardSpace.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Created by james on 11/27/16.
 */
public class BoardTest {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testBoardSpaceConnections() {
        try {
            Board board = new Board();

            // Sample connections
            assertTrue(board.isDirectedConnection(WHITE_START, BALLROOM__KITCHEN));
            assertTrue(board.isDirectedConnection(LOUNGE, CONSERVATORY));
            assertTrue(board.isDirectedConnection(CONSERVATORY, LOUNGE));

            // Sample false connections
            assertFalse(board.isDirectedConnection(BALLROOM__KITCHEN, WHITE_START));

        } catch (GameModelException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testBoardFromJson() {
        try {
            BoardPayload payload = mapper.readValue("{    \"Ms. Scarlet\": \"Ballroom\",    \"Col. Mustard\": \"Ballroom\",    \"Mrs. White\": \"Ballroom\",    \"Mr. Green\": \"Kitchen\",    \"Mrs. Peacock\": \"Kitchen\",    \"Prof. Plum\": \"Kitchen\",    \"Candlestick\": \"Library\",    \"Knife\": \"Library\",    \"Pipe\": \"Library\",    \"Revolver\": \"Library\",    \"Rope\": \"Library\",    \"Wrench\": \"Library\"}", BoardPayload.class);
            Board board = Board.initializeFromPayload(payload);
            System.out.println(board);
            // TODO: make a real test here
            // TODO: read JSON from file
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        } catch (GameModelException e) {
            e.printStackTrace();
            fail();
        }
    }
}
