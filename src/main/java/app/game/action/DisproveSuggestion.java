package app.game.action;

import app.game.model.GameModel;

/**
 * Created by james on 11/26/16.
 */
public class DisproveSuggestion implements Action {


    private String message;

    public boolean isLegal(GameModel model) {
        // stub
        return true;
    }
    public void apply(GameModel model) {
        // stub
    }
    public String getMessage() {
        return message;
    }
}
