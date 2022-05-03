package commands;

import data.Person;
import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

import java.util.ArrayList;

/**
 * A class that implements a command to delete all elements of a collection whose key value (id) is more than the specified one
 */

public class RemoveGreaterCommand extends Command {
    RemoveGreaterCommand () {
        super("remove_greater", "id {element}", "удалить из коллекции все элементы, превышающие заданный");
    }

    public void execute(CommandController controller, String[] args) {
        if (controller.getDataController().getTreeMap().isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        int id = Integer.parseInt(args[1]);
        ArrayList<Integer> ids = new ArrayList<>();
        for (Person i: controller.getDataController().getTreeMap().values()) {
            if (i.getId() > id)
                ids.add(i.getId());
        }
        for (Integer i: ids)
            controller.getDataController().getTreeMap().remove(i);
    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length > 2)
            throw new MissingArgumentException("у команды remove_greater_key лишь один аргумент");
        if (args.length == 1)
            throw new MissingArgumentException("для команды remove_greater_key нужен один аргумент");
        long id;
        try {
            id = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            throw new IncorrectArgumentException ("значение должно быть целым числом");
        }
    }
}