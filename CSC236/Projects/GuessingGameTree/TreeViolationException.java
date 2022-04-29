package GuessingGameTree;

public class TreeViolationException extends RuntimeException {
    public TreeViolationException() {
        super();
    }
    public TreeViolationException(String message) {
        super(message);
    }
}