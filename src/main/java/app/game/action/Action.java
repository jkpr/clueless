package app.game.action;

import app.game.GameModel;
import app.game.Player;

/**
 * Created by james on 11/26/16.
 */
public interface Action {
    boolean isLegal(GameModel model);
    void apply(GameModel model);
}
