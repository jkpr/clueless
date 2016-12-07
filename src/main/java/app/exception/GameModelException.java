package app.exception;

/**
 * Created by james on 11/27/16.
 */
public class GameModelException extends Exception {
    private int status;
    private String message;

    public GameModelException() {
        super();
    }

    public GameModelException(int status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public GameModelException(int status) {
        super();
        this.status = status;
        message = null;
    }

    public GameModelException(String message){
        super();
        status = 0;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
