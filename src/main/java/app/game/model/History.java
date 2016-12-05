package app.game.model;

import app.game.action.Action;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by james on 11/26/16.
 */
public class History {
    List<Action> history;

    public History() {
        history = new LinkedList<>();
    }

    public void addHistory(Action action) {
        history.add(action);
    }

    public List<Action> getHistory() {
        return history;
    }
}
