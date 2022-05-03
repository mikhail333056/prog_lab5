
package exceptions;

/**
 * A class that implements an error thrown when the number of command arguments is incorrect
 */
public class MissingArgumentException extends Exception {
    public MissingArgumentException (String message) {
        super(message);
    }
}