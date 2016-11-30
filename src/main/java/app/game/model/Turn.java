package app.game.model;

import app.game.Player;

/**
 * Created by james on 11/29/16.
 */
public class Turn {
    Player who;
    boolean hasMoved;
    boolean hasSuggested;
    Player whoCanDisprove;
    Card suggestedCharacter;
    Card suggestedWeapon;
    Card suggestedRoom;

    Turn() {
        nextTurn(null);
    }

    void nextTurn(Player next) {
        who = next;
        hasMoved = false;
        hasSuggested = false;
        whoCanDisprove = null;
        suggestedCharacter = null;
        suggestedWeapon = null;
        suggestedRoom = null;
    }
}
