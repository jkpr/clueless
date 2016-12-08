package app.game.model;

import app.exception.GameModelException;
import app.json.GameModelPayload;
import app.json.PlayerPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by james on 11/26/16.
 */
public class GameModel {
    private static final Logger logger = LoggerFactory.getLogger(GameModel.class);

    public static final int MIN_PLAYERS = 3;
    public static final int MAX_PLAYERS = 6;

    private Dealer dealer;
    private Board board;
    private List<Player> players;
    private History history;
    private Murder murder;
    private GameStatus status;
    private Turn turn;
    // TODO: make this more elegant (check history for moves)
    private Map<String, Boolean> wasMoved;
    private Player winner;

    public GameModel() {
        dealer = new Dealer();
        board = new Board();
        board.initialize();
        players = new LinkedList<>();
        history = new History();
        murder = null;
        status = GameStatus.SETUP;
        turn = new Turn();
        // TODO: make this more elegant
        wasMoved = new HashMap<>();
        initializeWasMoved();
        
        winner = null;
    }

    public Player getPlayerByCharacter(Character character) {
        for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
            Player next = iter.next();
            // TODO: Maybe need to get by character name
            if (next.getCharacter().equals(character)) {
                return next;
            }
        }
        return null;
    }

    public void startGame() {
        initialize();
        status = GameStatus.ACTIVE;
    }

    private void initialize() {
        createMurderAndDealCards();
        initializeTurns();
    }

    private void createMurderAndDealCards() {
        Dealer.DealResult result = dealer.deal(players.size());
        murder = result.murder;
        for(Player player : players) {
            List<Card> hand = result.hands.remove(0);
            player.setHand(hand);
        }
    }

    private void initializeTurns() {
        List<Player> turnOrder = new LinkedList<>();
        try {
            Player msScarlet = getPlayerByCharacter(board.getCharacter(Character.MS_SCARLET));
            Player colMustard = getPlayerByCharacter(board.getCharacter(Character.COL_MUSTARD));
            Player mrsWhite = getPlayerByCharacter(board.getCharacter(Character.MRS_WHITE));
            Player mrGreen = getPlayerByCharacter(board.getCharacter(Character.MR_GREEN));
            Player mrsPeacock = getPlayerByCharacter(board.getCharacter(Character.MRS_PEACOCK));
            Player profPlum = getPlayerByCharacter(board.getCharacter(Character.PROF_PLUM));
            if (msScarlet != null) {
                msScarlet.setStatus(GameStatus.ACTIVE);
                turnOrder.add(msScarlet);
            }
            if (colMustard != null) {
                colMustard.setStatus(GameStatus.ACTIVE);
                turnOrder.add(colMustard);
            }
            if (mrsWhite != null) {
                mrsWhite.setStatus(GameStatus.ACTIVE);
                turnOrder.add(mrsWhite);
            }
            if (mrGreen != null) {
                mrGreen.setStatus(GameStatus.ACTIVE);
                turnOrder.add(mrGreen);
            }
            if (mrsPeacock != null) {
                mrsPeacock.setStatus(GameStatus.ACTIVE);
                turnOrder.add(mrsPeacock);
            }
            if (profPlum != null) {
                profPlum.setStatus(GameStatus.ACTIVE);
                turnOrder.add(profPlum);
            }
            players = turnOrder;
            if (players.size() > 0) {
                turn.nextTurn(players.get(0));
            } else {
                // should never happen
                turn.nextTurn(null);
            }
        } catch (GameModelException e) {
            // should never happen
            e.printStackTrace();
        }
    }

    private void initializeWasMoved() {
        wasMoved = new HashMap<>();
        wasMoved.put(Character.MS_SCARLET, false);
        wasMoved.put(Character.COL_MUSTARD, false);
        wasMoved.put(Character.MRS_WHITE, false);
        wasMoved.put(Character.MR_GREEN, false);
        wasMoved.put(Character.MRS_PEACOCK, false);
        wasMoved.put(Character.PROF_PLUM, false);
    }

    public void endTurn() {
        wasMoved.put(turn.getWho().getCharacter().getName(), false);
        turn.nextTurn(getNextTurn());
    }

    private Player getNextTurn() {
        List<Player> activePlayers = getActivePlayers();
        for (Iterator<Player> iter = activePlayers.iterator(); iter.hasNext(); ) {
            Player player = iter.next();
            if ((player == turn.getWho()) && iter.hasNext()) {

                return iter.next();
            }
        }
        return activePlayers.get(0);
    }

    private List<Player> getActivePlayers() {
        List<Player> activePlayers = players.stream()
                .filter(p -> p.getStatus() == GameStatus.ACTIVE)
                .collect(Collectors.toList());
        return activePlayers;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public Board getBoard() {
        return board;
    }

    public Murder getMurder() {
        return murder;
    }

    public void setMurder(Murder murder) {
        this.murder = murder;
    }

    public History getHistory() {
        return history;
    }

    public Turn getTurn() {
        return turn;
    }

    public List<Player> getTurnOrder() {
        return getActivePlayers();
    }

    public void removeFromTurnOrder(Player player) {
        player.setStatus(GameStatus.FINISHED);
    }

    public boolean allPlayersSet() {
        boolean allSet = true;
        for (Player player : players) {
            if (player.getCharacter() == null) {
                allSet = false;
                break;
            }
        }
        return allSet;
    }

    // create for brand new, initialize to setup existing
    public static GameModel createFromPayload(GameModelPayload payload) throws GameModelException {
        GameModel model = new GameModel();
        // Board
        model.board.initializeFromPayload(payload.getBoard());
        // Players
        for (PlayerPayload playerPayload : payload.getPlayers()) {
            Player player = new Player();
            player.setCharacter(model.board.getCharacter(playerPayload.getCharacter()));
            for (String card : playerPayload.getHand()) {
                player.acceptCard(model.dealer.getCard(card));
            }
            model.addPlayer(player);
        }
        // Murder
        Card character = model.dealer.getCard(payload.getMurder().getCharacter());
        Card weapon = model.dealer.getCard(payload.getMurder().getWeapon());
        Card room = model.dealer.getCard(payload.getMurder().getRoom());
        Murder murder = new Murder(character, weapon, room);
        model.setMurder(murder);
        // TODO Make sure all the cards are dealt, if not throw GameModelException
        // Turn
        model.turn.setWho(model.getPlayerByCharacter(model.board.getCharacter(payload.getTurn().getWho())));
        model.turn.setHasMoved(payload.getTurn().getHasMoved());
        model.turn.setHasSuggested(payload.getTurn().getHasSuggested());
        model.turn.setWhoCanDisprove(model.getPlayerByCharacter(model.board.getCharacter(payload.getTurn().getWhoCanDisprove())));
        model.turn.setSuggestedCharacter(model.dealer.getCard(payload.getTurn().getSuggestedCharacter()));
        model.turn.setSuggestedWeapon(model.dealer.getCard(payload.getTurn().getSuggestedWeapon()));
        model.turn.setSuggestedRoom(model.dealer.getCard(payload.getTurn().getSuggestedRoom()));


        // TODO implement History sometime

        // Game status
        model.status = payload.getStatus();

        // Was moved
        for (Map.Entry<String, Boolean> entry : payload.getWasMoved().entrySet()) {
            Character token = model.getBoard().getCharacter(entry.getKey());
            model.wasMoved.put(token.getName(), entry.getValue());
        }
        // TODO make sure all characters are in there

        return model;
    }

    public GameModelPayload toPayload() {
        GameModelPayload payload = new GameModelPayload();
        payload.setStatus(status);
        payload.setBoard(board.toPayload());
        List<PlayerPayload> playerPayloads = new ArrayList<>();
        for (Player player : players) {
            playerPayloads.add(player.toPayload());
        }
        payload.setPlayers(playerPayloads);
        if (murder != null) {
            payload.setMurder(murder.toPayload());
        }
        payload.setTurn(turn.toPayload());

        payload.setWasMoved(new HashMap<>());
        for (Map.Entry<String, Boolean> entry : wasMoved.entrySet()) {
            payload.getWasMoved().put(entry.getKey(), entry.getValue());
        }

        // TODO history
        return payload;
    }

    public String toVisualString() {
        StringBuilder sb = new StringBuilder();
        sb.append(board.toVisualString());
        //sb.append("\n\n");
        sb.append(turn.toVisualString());
        sb.append("\n\n");
        long unsetCount = players.stream().filter(p -> !p.isCharacterSet()).count();
        if (unsetCount > 0) {
            sb.append("Number of unset players: ");
            sb.append(unsetCount);
            sb.append("\n");
        }
        if (players.size() - unsetCount > 0) {
            for (Player player : players) {
                if (player.isCharacterSet()) {
                    sb.append(player.toVisualString());
                    sb.append("\n");
                }
            }
        }
        List<String> moved = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : wasMoved.entrySet()) {
            if (entry.getValue()) {
                moved.add(entry.getKey());
            }
        }
        if (!moved.isEmpty()) {
            sb.append("\n");
            sb.append("Was moved by suggestion: ");
            sb.append(String.join(", ", moved));
            sb.append("\n");
        }
        if (!players.isEmpty() || !moved.isEmpty()) {
            sb.append("\n");
        }
        if (murder != null) {
            sb.append(murder.toVisualString());
        }
        return sb.toString();
    }

    public boolean wasMoved(Character character) {
        return wasMoved.get(character.getName());
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getWhoCanDisprove(Card character, Card weapon, Card room) {
        List<Player> playersSuggestion = new ArrayList<>();

        Player currentPlayer = turn.getWho();
        Iterator<Player> iter = players.iterator();
        while (iter.hasNext()) {
            Player player = iter.next();
            if (player == currentPlayer) {
                break;
            }
        }

        // loop back to the beginning
        if (!iter.hasNext()) {
            iter = players.iterator();
        }

        while (iter.hasNext()) {
            Player player = iter.next();
            if (player == currentPlayer) {
                break;
            }
            playersSuggestion.add(player);
            List<Card> hand = player.getHand();
            if (hand.contains(character) || hand.contains(weapon) || hand.contains(room)) {
                return playersSuggestion;
            }
            // loop back to the beginning
            if (!iter.hasNext()) {
                iter = players.iterator();
            }
        }
        // No one found
        return null;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public String getStatusMessage() {
        if (status == GameStatus.SETUP) {
            return "In setup...";
        } else if (status == GameStatus.ACTIVE) {
            String name = turn.getWho().getCharacter().getName();
            return String.format("It is %s's turn", name);
        } else if (status == GameStatus.ACTIVE_SUGGESTION) {
            String name = turn.getWhoCanDisprove().getCharacter().getName();
            return String.format("%s can disprove", name);
        } else { // status == GameStatus.FINISHED
            String name = winner.getCharacter().getName();
            return String.format("%s has won the game", name);
        }
    }

    public Map<String, Boolean> getWasMoved() {
        return wasMoved;
    }

    public List<String> getAllSetPlayerNames() {
        return players.stream().filter(p -> p.isCharacterSet())
                .map(p -> p.getCharacter().getName())
                .collect(Collectors.toList());
    }

    public List<String> getAllActivePlayerNames() {
        return players.stream().filter(p -> p.isCharacterSet() && p.getStatus() != GameStatus.FINISHED)
                .map(p -> p.getCharacter().getName())
                .collect(Collectors.toList());
    }
}
