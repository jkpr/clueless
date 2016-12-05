package app.game.action;

import app.game.model.GameModel;

/**
 * Created by james on 11/26/16.
 */
public interface Action {
    boolean isLegal(GameModel model);
    void apply(GameModel model);
    String getMessage();
}
