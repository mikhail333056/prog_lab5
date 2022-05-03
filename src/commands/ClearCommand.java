package commands;

import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 * Implements the collection cleanup command
 */
public class ClearCommand extends Command {
    ClearCommand () {
        super("clear", "", "очищает коллекцию");
    }

    public void execute(CommandController controller, String[] args) {
        if (controller.getDataController().getTreeMap().isEmpty()) {
            System.out.println("Коллекция уже пуста.");
            return;
        }
        controller.getDataController().getTreeMap().clear();
        System.out.println("Коллекция успешно очищена.");
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}