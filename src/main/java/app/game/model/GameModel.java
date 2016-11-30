package app.game.model;

import app.game.Player;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by james on 11/26/16.
 */
public class GameModel {
    private Dealer dealer;
    private Board board;
    private List<Player> players;
    private Murder murder;
    private GameStatus status;
    private Turn turn;

    public GameModel() {
        dealer = new Dealer();
        board = new Board();
        players = new LinkedList<>();
        murder = null;
        status = GameStatus.SETUP;
        turn = new Turn();
        
        board.initialize();
    }

    public boolean addPlayer(Player player) {
        for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
            Player next = iter.next();
            if (next.getUser().equals(player.getUser())) {
                return false;
            }
        }
        players.add(player);
        return true;
    }

    public Player getPlayerByUser(String user) {
        for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
            Player next = iter.next();
            if (next.getUser().equals(user)) {
                return next;
            }
        }
        return null;
    }

    public void createMurderAndDealCards() {
        Dealer.DealResult result = dealer.deal(players.size());
        murder = result.murder;
        Collections.shuffle(result.hands);
        for( Player player : players) {
            List<Card> hand = result.hands.remove(0);
            player.setHand(hand);
        }
    }
}
