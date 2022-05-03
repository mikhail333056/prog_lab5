package commands;

import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 * A class that implements the command to interrupt the program
 */
public class ExitCommand extends Command {
    ExitCommand () {
        super("exit", "", "завершает программу (без сохранения в файл)");
    }

    public void execute(CommandController controller, String[] args) {
        System.out.println("Прерывание работы программы...");
        System.exit(0);
    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}