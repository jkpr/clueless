package app.json;

import java.util.List;

/**
 * Created by jpringle on 12/4/16.
 */
public class GameModelPayload {
    //TODO GameModel status
    //TODO wasMoved
    private BoardPayload board;
    private List<PlayerPayload> players;
    private MurderPayload murder;
    private List<String> turnOrder;
    private TurnPayload turn;
    private List<String> history;

    public BoardPayload getBoard() {
        return board;
    }

    public void setBoard(BoardPayload board) {
        this.board = board;
    }

    public List<PlayerPayload> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerPayload> players) {
        this.players = players;
    }

    public TurnPayload getTurn() {
        return turn;
    }

    public void setTurn(TurnPayload turn) {
        this.turn = turn;
    }

    public MurderPayload getMurder() {
        return murder;
    }

    public void setMurder(MurderPayload murder) {
        this.murder = murder;
    }

    public List<String> getTurnOrder() {
        return turnOrder;
    }

    public void setTurnOrder(List<String> turnOrder) {
        this.turnOrder = turnOrder;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }
}
