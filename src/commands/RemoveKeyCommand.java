package commands;

import data.Person;
import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 * A class that implements a command to delete a collection item by a given key (id value)
 */
public class RemoveKeyCommand extends Command {
    RemoveKeyCommand () {
        super("remove_key", "id", "удаляет элемент по заданному id");
    }

    public void execute(CommandController controller, String[] args) {

        System.out.println("Удаление человека по id "+args[1]);
        controller.getDataController().getTreeMap().remove(Long.parseLong(args[1]));
        System.out.println("Человек успешно удалён");
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length > 2)
            throw new MissingArgumentException("у команды remove_key лишь один аргумент - id");
        if (args.length == 1)
            throw new MissingArgumentException("id - обязательный аргумент для remove_key");
        long id;
        try {
            id = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            throw new IncorrectArgumentException("id должно быть целым числом");
        }
        if (!controller.getDataController().getTreeMap().containsKey(id)) {
            throw new IncorrectArgumentException("человека с таким id в коллекции не существует");
        }
    }
}