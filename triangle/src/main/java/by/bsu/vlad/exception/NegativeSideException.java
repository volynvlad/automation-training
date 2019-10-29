package by.bsu.vlad.exception;

public class NegativeSideException extends Exception {
    public NegativeSideException() {

    }

    public NegativeSideException(String message) {
        super(message);
    }

    public NegativeSideException(Throwable cause) {
        super(cause);
    }

    public NegativeSideException(String message, Throwable cause) {
        super(message, cause);
    }
}
