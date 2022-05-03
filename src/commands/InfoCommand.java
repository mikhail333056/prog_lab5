package commands;

import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 * A class that implements a command to output information about a collection
 */
public class InfoCommand extends Command {
    InfoCommand () {
        super("info", "", "выводит информацию о коллекции");
    }

    public void execute(CommandController controller, String[] args) {
        System.out.println("Тип коллекции - TreeMap, коллекция состоит из "+controller.getDataController().getTreeMap().size()+" элементов.");
        System.out.println("Ключом у коллекции выступает значение id.");
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}