package exceptions;

/**
 * A class that implements an error that is thrown when the command arguments are entered incorrectly
 */
public class IncorrectArgumentException extends Exception {
    public IncorrectArgumentException (String message) {
        super(message);
    }
}