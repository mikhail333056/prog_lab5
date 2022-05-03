package commands;

import data.Person;
import exceptions.IncorrectArgumentException;
import exceptions.IncorrectValueException;
import exceptions.MissingArgumentException;

import java.util.ArrayList;

public class FilterLessThanLocationCommand extends Command{
    FilterLessThanLocationCommand () {
        super("filter_less_than_location", "location", "вывести элементы, значение поля location которых меньше заданного");
    }

    public void execute(CommandController controller, String[] args) {
        if (controller.getDataController().getTreeMap().isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        String location = args[1];
        ArrayList<Integer> id = new ArrayList<>();
        for (Person i: controller.getDataController().getTreeMap().values()) {
            if (i.getLocation().getName().length() < location.length())
                id.add(i.getId());
        }
        for (Integer i: id)
            System.out.println(controller.getDataController().getTreeMap().get(i));
    }
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length > 2)
            throw new MissingArgumentException("у команды filter_less_than_location лишь один аргумент");
        if (args.length == 1)
            throw new MissingArgumentException("для команды filter_less_than_location нужен один аргумент");
        String location;
        try {
            location = args[1];
        } catch (IncorrectValueException e) {
            throw new IncorrectArgumentException ("значение должно быть символом");
        }
    }
}
