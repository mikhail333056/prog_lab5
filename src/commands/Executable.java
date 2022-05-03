package commands;

import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 * Sets the basic constructs of the command necessary for its implementation
 */
public interface Executable {
    void execute (CommandController controller, String[] args);

    void checkArgs (CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException;
}