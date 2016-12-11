package app.game.action;

import app.exception.GameModelException;
import app.game.model.*;
import app.game.model.Character;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by james on 11/26/16.
 */
public class MakeSuggestion implements Action {
    private static final Logger logger = LoggerFactory.getLogger(MakeSuggestion.class);
    public static final String NAME = "MakeSuggestion";

    private String message;
    // TODO: message?
    private String toString;

    private Player player;
    private String character;
    private String weapon;

    private Card characterCard;
    private Card weaponCard;
    private Card roomCard;

    public MakeSuggestion(Player player, String character, String weapon) {
        this.player = player;
        this.character = character;
        this.weapon = weapon;
    }

    public boolean isLegal(GameModel model) {
        boolean legal = false;

        if (player == null) {
            message = "User has not joined the game and thus cannot affect the game.";
            return false;
        } else if (model.getStatus() != GameStatus.ACTIVE) {
            message = "Game not being played";
            return false;
        }

        try {
            characterCard = model.getDealer().getCard(character);
            weaponCard = model.getDealer().getCard(weapon);
            roomCard = model.getDealer().getCard(player.getCharacter().getSpace().name);
            boolean characterType = characterCard.type == GameProperty.CHARACTER;
            boolean weaponType = weaponCard.type == GameProperty.WEAPON;
            boolean roomType = roomCard.type == GameProperty.ROOM;
            boolean correctCards = characterType && weaponType && roomType;
            boolean activeGame = model.getStatus() == GameStatus.ACTIVE;
            boolean yourTurn = model.getTurn().getWho() == player;
            boolean wasMoved = model.wasMoved(player.getCharacter());
            boolean hasMoved = model.getTurn().getHasMoved();
            boolean hasNotSuggested = !model.getTurn().getHasSuggested();
            boolean inCorrectRoom = player.getCharacter().getSpace().name.equals(roomCard.name);

            if (!activeGame) {
                message = "Game not being played";
            } else if (!yourTurn) {
                message = String.format("It is not %s's turn", player.getCharacter().getName());
            } else if (!wasMoved && !hasMoved) {
                message = String.format("%s has not moved yet this turn and was not moved by suggestion", player.getCharacter().getName());
            } else if (!hasNotSuggested) {
                message = String.format("%s has already made a suggestion", player.getCharacter().getName());
            } else if (!inCorrectRoom) {
                message = String.format("%s is not in the suggested room %s", player.getCharacter().getName(), roomCard.name);
            } else if (!characterType) {
                message = String.format("%s is not a character", character);
            } else if (!weaponType) {
                message = String.format("%s is not a weapon", weapon);
            } else if (!roomType) {
                message = String.format("%s is not a room", roomCard.name);
            }

            legal = activeGame && yourTurn && (wasMoved || hasMoved) && hasNotSuggested && inCorrectRoom && correctCards;
        } catch (GameModelException e) {
            // Dealer unable to determine the card. Keep legal as false.
            message = String.format("There is no card named %s", e.getMessage());
        }
        return legal;
    }
    public void apply(GameModel model) {
        try {
            model.getTurn().setHasSuggested(true);
            Token characterToken = model.getBoard().getCharacter(characterCard.name);
            characterToken.setSpace(model.getBoard().getBoardSpace(roomCard.name));
            Token weaponToken = model.getBoard().getWeapon(weaponCard.name);
            weaponToken.setSpace(model.getBoard().getBoardSpace(roomCard.name));
            model.getWasMoved().put(characterCard.name, true);
            List<Player> playersSuggested = model.getWhoCanDisprove(characterCard, weaponCard, roomCard);
            if (playersSuggested != null) {
                model.setStatus(GameStatus.ACTIVE_SUGGESTION);
                Player whoCanDisprove = playersSuggested.get(playersSuggested.size() - 1);
                model.getTurn().setWhoCanDisprove(whoCanDisprove);
                model.getTurn().setSuggestedCharacter(characterCard);
                model.getTurn().setSuggestedWeapon(weaponCard);
                model.getTurn().setSuggestedRoom(roomCard);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s suggested it was %s with the %s in the %s.", player.getCharacter().getName(), characterCard.name, weaponCard.name, roomCard.name));
            if (playersSuggested != null) {
                Player whoCanDisprove = playersSuggested.remove(playersSuggested.size() - 1);
                List<String> whoCannot = new LinkedList<>();
                for (Player player : playersSuggested) {
                    whoCannot.add(player.getCharacter().getName());
                }
                if (!whoCannot.isEmpty()) {
                    sb.append(" ");
                    sb.append(String.join(", ", whoCannot));
                    sb.append(" cannot disprove.");
                }
                sb.append(" ");
                sb.append(whoCanDisprove.getCharacter().getName());
                sb.append(" can disprove.");
            } else {
                sb.append(" No one can disprove.");
            }
            toString = sb.toString();
            model.getHistory().addHistory(this);
        } catch (GameModelException e) {
            // should never happen ...
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return toString;
    }

    public String toString(Player player) {
        return toString();
    }

    public String getMessage() {
        return message;
    }
}
