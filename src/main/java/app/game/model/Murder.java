package app.game.model;

import app.json.MurderPayload;

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

    public Card getCharacter() {
        return character;
    }

    public Card getWeapon() {
        return weapon;
    }

    public Card getRoom() {
        return room;
    }



    public String toVisualString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Murder: ");
        sb.append(String.join(", ", character.name, weapon.name, room.name));
        return sb.toString();
    }
}
