package exceptions;

/**
 * A class that implements an error that is thrown when the values of the fields of the collection elements are entered incorrectly
 */
public class IncorrectValueException extends RuntimeException {
    public IncorrectValueException (String message) {
        super(message);
    }
}