package commands;

import data.Person;
import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 * A class that implements the command to insert a new Person element into the collection
 */
public class InsertCommand extends Command {
    InsertCommand () {
        super("insert", "id {element}", "добавить новый элемент с заданным id");
    }

    public void execute(CommandController controller, String[] args) {
        Person person = controller.getDataController().getConsoleController().createPerson();
        if (person == null) {
            System.out.println("Коллекция не была изменена.");
            return;
        }
        person.setId(Integer.parseInt(args[1]));
        controller.getDataController().addPerson(person);
        System.out.println("Человек был успешно добавлен в коллекцию.");
    }
    public void checkArgs(final CommandController controller, final String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length > 2)
            throw new MissingArgumentException("у команды insert лишь один аргумент - id");
        if (args.length == 1)
            throw new MissingArgumentException("id - обязательный аргумент для insert");
        int id;
        try {
            id = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new IncorrectArgumentException ("id должно быть целым числом");
        }
        if (!Person.checkUniqueId(controller.getDataController().getTreeMap(), id))
            throw new IncorrectArgumentException("id должен быть уникальным для этой коллекции");
    }
}