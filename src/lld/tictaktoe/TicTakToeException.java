package lld.tictaktoe;

public class TicTakToeException extends Exception {
    private String message;

    public TicTakToeException(String message) {
        this.message = message;
    }
}
