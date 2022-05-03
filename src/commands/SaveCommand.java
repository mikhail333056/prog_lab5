package commands;

import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 * A class that implements saving collection data to a file at a specified path
 */
public class SaveCommand extends Command {
    SaveCommand () {
        super("save", "", "сохраняет коллекцию в файл");
    }

    @Override
    public void execute(CommandController controller, String[] args) {
        controller.getDataController().getFileController().writeCSVFile(controller.getDataController().getPath());
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}