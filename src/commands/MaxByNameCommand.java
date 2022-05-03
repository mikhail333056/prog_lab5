package commands;

import data.Person;
import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

import java.util.ArrayList;

public class MaxByNameCommand extends Command {
    MaxByNameCommand () {
        super("max_by_name", "", "вывести любой объект из коллекции, значение поля name которого является максимальным");
    }

    public void execute(CommandController controller, String[] args) {
        if (controller.getDataController().getTreeMap().isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }

        //int sum_of_height = 0;
        String maxName = "";
        for (Person i: controller.getDataController().getTreeMap().values()) {
            //sum_of_height+=i.getHeight();
            if (i.getName().length() > maxName.length()) {
                maxName = i.getName();
            }
        }
        System.out.println("максимальное по длине имя: " + maxName);
    }
    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }

}
