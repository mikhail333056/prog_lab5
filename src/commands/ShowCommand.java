package commands;

import data.Person;
import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 * A class that implements the output of information about all elements of the collection
 */
public class ShowCommand extends Command {
    ShowCommand () {
        super("show", "", "выводит все элементы коллекции");
    }

    public void execute(CommandController controller, String[] args) {
        if (controller.getDataController().getTreeMap().isEmpty()) {
            System.out.println("Коллекция пустая.");
            return;
        }
        for (Person i: controller.getDataController().getTreeMap().values()) {
            System.out.println("Person " + i.getId() +": "+ i);
        }
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}