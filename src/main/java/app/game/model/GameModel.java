package app.game.model;

import app.exception.GameModelException;
import app.game.action.*;
import app.json.GameModelPayload;
import app.json.PlayerPayload;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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

    public String getStatusWho() {
        String whoseMove = "";
        if (status == GameStatus.ACTIVE) {
            whoseMove = turn.getWho().getCharacter().getName();
        } else if (status == GameStatus.ACTIVE_SUGGESTION) {
            whoseMove = turn.getWhoCanDisprove().getCharacter().getName();
        } else if (status == GameStatus.FINISHED) {
            whoseMove = winner.getCharacter().getName();
        }
        return whoseMove;
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

    public List<Action> getAllLegalActions(Player player) {
        return null;
    }

    public List<Token> getFreeCharacters() {
        List<Token> allCharacters = board.getAllCharacters();
        for (Player player : players) {
            allCharacters.remove(player.getCharacter());
        }
        return allCharacters;
    }

    public JSONObject getAllLegalActionsJson(String user, Player player, boolean isHost) {
        JSONObject json = new JSONObject();

        try {
            if (status == GameStatus.SETUP) {
                if (player == null) {
                    AddPlayer addPlayer = new AddPlayer(user, new Player(), false);
                    if (addPlayer.isLegal(this)) {
                        json.put(AddPlayer.NAME, true);
                    }
                } else {
                    // Player is set
                    for (Token token : board.getAllCharacters()) {
                        SetToken setToken = new SetToken(user, player, token.getName());
                        if (setToken.isLegal(this)) {
                            if (json.has(SetToken.NAME)) {
                                JSONArray list = (JSONArray) json.get(SetToken.NAME);
                                list.put(token.getName());
                            } else {
                                List<String> list = new ArrayList<>();
                                list.add(token.getName());
                                json.put(SetToken.NAME, list);
                            }
                        }
                    }

                    StartGame action = new StartGame(user, isHost);
                    if (action.isLegal(this)) {
                        json.put(StartGame.NAME, true);
                    }
                }
            } else if (status == GameStatus.ACTIVE) {
                if (player != null) {
                    // Move
                    try {
                        BoardSpace boardSpace = player.getCharacter().getSpace();
                        for (BoardSpace space : board.getSpaceConnections(boardSpace)) {
                            Move move = new Move(player, space.name);
                            if (move.isLegal(this)) {
                                if (json.has(Move.NAME)) {
                                    JSONArray list = (JSONArray) json.get(Move.NAME);
                                    list.put(space.name);
                                } else {
                                    List<String> list = new ArrayList<>();
                                    list.add(space.name);
                                    json.put(Move.NAME, list);
                                }
                            }
                        }
                    } catch (GameModelException e) {
                        e.printStackTrace();
                    }

                    // MakeSuggestion
                    Action makeSuggestion = new MakeSuggestion(player, Character.MS_SCARLET, Weapon.CANDLESTICK);
                    if (makeSuggestion.isLegal(this)) {
                        json.put(MakeSuggestion.NAME, true);
                    }

                    // DisproveSuggestion
                    Card suggestedCharacter = turn.getSuggestedCharacter();
                    Card suggestedWeapon = turn.getSuggestedWeapon();
                    Card suggestedRoom = turn.getSuggestedRoom();
                    if (suggestedCharacter != null || suggestedWeapon != null || suggestedRoom != null) {
                        // Character
                        Action disproveCharacter = new DisproveSuggestion(player, suggestedCharacter.name);
                        if (disproveCharacter.isLegal(this)) {
                            List<String> disprovals = new ArrayList<>();
                            disprovals.add(suggestedCharacter.name);
                            json.put(DisproveSuggestion.NAME, disprovals);
                        }
                        // Weapon
                        Action disproveWeapon = new DisproveSuggestion(player, suggestedWeapon.name);
                        if (disproveWeapon.isLegal(this)) {
                            if (json.has(DisproveSuggestion.NAME)) {
                                JSONArray list = (JSONArray) json.get(DisproveSuggestion.NAME);
                                list.put(suggestedWeapon.name);
                            } else {
                                List<String> disprovals = new ArrayList<>();
                                disprovals.add(suggestedWeapon.name);
                                json.put(DisproveSuggestion.NAME, disprovals);
                            }
                        }
                        // Room
                        DisproveSuggestion disproveRoom = new DisproveSuggestion(player, suggestedRoom.name);
                        if (disproveRoom.isLegal(this)) {
                            if (json.has(DisproveSuggestion.NAME)) {
                                JSONArray list = (JSONArray) json.get(DisproveSuggestion.NAME);
                                list.put(suggestedRoom.name);
                            } else {
                                List<String> disprovals = new ArrayList<>();
                                disprovals.add(suggestedRoom.name);
                                json.put(DisproveSuggestion.NAME, disprovals);
                            }
                        }

                    }

                    // MakeAccusation
                    MakeAccusation makeAccusation = new MakeAccusation(player, Character.MS_SCARLET, Weapon.CANDLESTICK, BoardSpace.HALL);
                    if (makeAccusation.isLegal(this)) {
                        json.put(MakeAccusation.NAME, true);
                    }

                    // EndTurn
                    EndTurn endTurn = new EndTurn(player);
                    if (endTurn.isLegal(this)) {
                        json.put(EndTurn.NAME, true);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return json;
    }
}
