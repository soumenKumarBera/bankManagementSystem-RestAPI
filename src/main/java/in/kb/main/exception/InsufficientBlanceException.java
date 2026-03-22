package in.kb.main.exception;

public class InsufficientBlanceException extends RuntimeException {
    public InsufficientBlanceException(String message) {
        super(message);
    }
}
