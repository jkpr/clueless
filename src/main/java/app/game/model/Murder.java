package app.game.model;

/**
 * Created by james on 11/29/16.
 */
public class Murder {
    private final Card character;
    private final Card weapon;
    private final Card room;

    public Murder(Card character, Card weapon, Card room) {
        // TODO ensure the cards are of the correct type
        this.character = character;
        this.weapon = weapon;
        this.room = room;
    }

    public boolean isCorrectAssumption(Card character, Card weapon, Card room) {
        boolean correctCharacter = this.character.equals(character);
        boolean correctWeapon = this.character.equals(weapon);
        boolean correctRoom = this.character.equals(room);
        return correctCharacter && correctWeapon && correctRoom;
    }
}
