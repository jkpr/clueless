package app.game.model;

import app.exception.GameModelException;

/**
 * Created by james on 11/27/16.
 */
public class Card {

    public final String name;
    public final GameProperty cardType;

    public Card(String name) throws GameModelException {
        this.name = name;
        cardType = GameProperty.getType(name);
    }
}
