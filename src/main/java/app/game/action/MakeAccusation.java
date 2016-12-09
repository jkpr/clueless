package app.game.action;

import app.exception.GameModelException;
import app.game.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by james on 11/26/16.
 */
public class MakeAccusation implements Action {

    private static final Logger logger = LoggerFactory.getLogger(MakeAccusation.class);
    public static final String NAME = "MakeAccusation";

    private String message;

    private Player player;
    private String character;
    private String weapon;
    private String room;

    private Card characterCard;
    private Card weaponCard;
    private Card roomCard;

    private boolean isAccusationCorrect;

    public MakeAccusation(Player player, String character, String weapon, String room) {
        this.player = player;
        this.character = character;
        this.weapon = weapon;
        this.room = room;

        isAccusationCorrect = false;
    }

    public boolean isLegal(GameModel model) {
        boolean legal = false;

        try {
            boolean activeGame = model.getStatus() == GameStatus.ACTIVE;
            boolean yourTurn = model.getTurn().getWho() == player;

            characterCard = model.getDealer().getCard(character);
            weaponCard = model.getDealer().getCard(weapon);
            roomCard = model.getDealer().getCard(room);

            boolean characterType = characterCard.type == GameProperty.CHARACTER;
            boolean weaponType = weaponCard.type == GameProperty.WEAPON;
            boolean roomType = roomCard.type == GameProperty.ROOM;
            boolean correctCards = characterType && weaponType && roomType;

            if (!activeGame) {
                message = "Game not being played";
            } else if (!yourTurn) {
                message = String.format("It is not %s's turn", player.getCharacter().getName());
            } else if (!characterType) {
                message = String.format("%s is not a character", character);
            } else if (!weaponType) {
                message = String.format("%s is not a weapon", weapon);
            } else if (!roomType) {
                message = String.format("%s is not a room", roomCard.name);
            }

            legal = activeGame && yourTurn && correctCards;
        } catch (GameModelException e) {
            // Dealer unable to determine the card. Keep legal as false.
            message = String.format("There is no card named %s", e.getMessage());
        }
        return legal;
    }
    public void apply(GameModel model) {
        isAccusationCorrect = model.getMurder().isCorrectAccusation(characterCard, weaponCard, roomCard);
        if (isAccusationCorrect) {
            model.setStatus(GameStatus.FINISHED);
            model.setWinner(player);
        } else {
            // order is important
            model.endTurn();
            model.removeFromTurnOrder(player);
            // check for winner by default
            if (model.getTurnOrder().size() == 1) {
                model.setStatus(GameStatus.FINISHED);
                model.setWinner(model.getTurnOrder().get(0));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        sb.append(" ");
        sb.append(player.getCharacter().getName());
        if (isAccusationCorrect) {
            sb.append(" is correct and wins the game!");
        } else if (model.getTurnOrder().size() == 1) {
            sb.append(" is incorrect. ");
            sb.append(model.getTurnOrder().get(0).getCharacter().getName());
            sb.append(" wins the game!");
        } else {
            sb.append(" is incorrect and is removed from active gameplay.");
        }
        message = sb.toString();
        model.getHistory().addHistory(this);
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("%s made an accusation: it was %s with the %s in the %s.", player.getCharacter().getName(), character, weapon, room);
    }

    public String toString(Player player) {
        return toString();
    }
}
