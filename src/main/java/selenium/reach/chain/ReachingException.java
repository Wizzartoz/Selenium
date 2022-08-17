package selenium.reach.chain;

public class ReachingException extends Exception {
    public ReachingException() {
    }

    public ReachingException(String message) {
        super(message);
    }

    public ReachingException(String message, Throwable cause) {
        super(message, cause);
    }
}
