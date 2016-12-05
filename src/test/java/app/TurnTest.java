package app;

import app.json.TurnPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by james on 11/30/16.
 */
public class TurnTest {
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testTurnFromPayload() {
        try {
            InputStream turnStart = getClass().getResourceAsStream("/FirstTurnStart.json");
            TurnPayload startPayload = mapper.readValue(turnStart, TurnPayload.class);
            System.out.println(startPayload);

            InputStream midTurn = getClass().getResourceAsStream("/MidTurn.json");
            TurnPayload midPayload = mapper.readValue(midTurn, TurnPayload.class);
            System.out.println(midPayload);

            InputStream afterSuggestionTurn = getClass().getResourceAsStream("/AfterSuggestionTurn.json");
            TurnPayload afterPayload = mapper.readValue(afterSuggestionTurn, TurnPayload.class);
            mapper.writeValue(System.out, afterPayload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
