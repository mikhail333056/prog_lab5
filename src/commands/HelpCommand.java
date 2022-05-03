package commands;

import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 * A class that implements a command to output information about all specified commands in the program
 */
public class HelpCommand extends Command {
    HelpCommand () {
        super("help","","вызывает справку по всем командам");
    }

    public void execute(final CommandController controller, final String[] args) {
        for (Command i: controller.getAllCommands())
            System.out.println(i.getName() + (i.getSignature().equals("") ? "" : " " + i.getSignature()) + " - " + i.getDescription());
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}