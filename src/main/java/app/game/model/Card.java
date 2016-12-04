package app.game.model;

import app.exception.GameModelException;

/**
 * Created by james on 11/27/16.
 */

/*
5.5 Card
Represents all the cards in the deck. There are twenty-one total cards: nine rooms, six
character cards, and six weapon cards.
 */

public class Card {

    public final String name;
    public final GameProperty type;

    public Card(String name) throws GameModelException {
        this.name = name;
        type = GameProperty.getType(name);
    }
}
