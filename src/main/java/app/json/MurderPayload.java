package app.json;

/**
 * Created by james on 11/30/16.
 */
public class MurderPayload {
    public String character;
    public String weapon;
    public String room;

    public String getWeapon() {
        return weapon;
    }

    public String getCharacter() {
        return character;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setCharacter(String character) {
        this.character = character;
    }



    // Getters
    public String getRoom() {
        return room;
    }
}
