package app.game.action;

import app.exception.GameModelException;
import app.game.model.Card;
import app.game.model.GameModel;
import app.game.model.GameStatus;
import app.game.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 11/26/16.
 */
public class DisproveSuggestion implements Action {
    public static final String NAME = "DisproveSuggestion";

    private String message;

    List<Player> privy;
    Player player;
    String cardString;

    Card card;

    public DisproveSuggestion(Player player, String cardString) {
        this.player = player;
        this.cardString = cardString;
        privy = new ArrayList<>();
    }

    public boolean isLegal(GameModel model) {
        boolean legal = false;

        if (player == null) {
            message = "User has not joined the game and thus cannot affect the game.";
            return false;
        } else if (model.getStatus() != GameStatus.ACTIVE && model.getStatus() != GameStatus.ACTIVE_SUGGESTION) {
            message = "Game not being played";
            return false;
        }

        try {
            card = model.getDealer().getCard(cardString);

            boolean isActiveSuggestion = model.getStatus() == GameStatus.ACTIVE_SUGGESTION;
            boolean isNamedPlayer = model.getTurn().getWhoCanDisprove() == player;
            boolean playerHasCard = player.getHand().contains(card);
            boolean cardMatchesCharacter = model.getTurn().getSuggestedCharacter() == card;
            boolean cardMatchesWeapon = model.getTurn().getSuggestedWeapon() == card;
            boolean cardMatchesRoom = model.getTurn().getSuggestedRoom() == card;
            boolean cardMatch = cardMatchesCharacter || cardMatchesWeapon || cardMatchesRoom;

            if (!isActiveSuggestion) {
                message = "There is no current suggestion";
            } else if (!isNamedPlayer) {
                message = String.format("%s is not the suggested character, so cannot disprove", player.getCharacter().getName());
            } else if (!playerHasCard) {
                message = String.format("%s does not have the %s card, so cannot disprove with it", player.getCharacter().getName(), cardString);
            } else if (!cardMatch) {
                message = String.format("%s does not match any of the three suggested cards", cardString);
            }

            legal = isActiveSuggestion && isNamedPlayer && playerHasCard && cardMatch;
        } catch (GameModelException e) {
            // Dealer unable to determine the card. Keep legal as false.
            message = String.format("There is no card named %s", e.getMessage());
        }
        return legal;
    }
    public void apply(GameModel model) {
        privy.add(player);
        privy.add(model.getTurn().getWho());

        model.setStatus(GameStatus.ACTIVE);
        model.getTurn().clearSuggestion();
        model.getHistory().addHistory(this);
    }
    public String getMessage() {
        return message;
    }

    public String toString(Player player) {
        if (privy.contains(player)) {
            return String.format("%s revealed the %s card to %s", privy.get(0).getCharacter().getName(), cardString, privy.get(1).getCharacter().getName());
        } else {
            return String.format("%s revealed a card to %s", privy.get(0).getCharacter().getName(), privy.get(1).getCharacter().getName());
        }
    }
}
