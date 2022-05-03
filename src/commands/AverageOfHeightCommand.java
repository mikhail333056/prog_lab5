package commands;

import data.Person;
import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

import java.util.ArrayList;
public class AverageOfHeightCommand extends Command {
    AverageOfHeightCommand() {
        super("average_of_height", "", "вывести среднее значение поля height для всех элементов коллекции");
    }
    public void execute(CommandController controller, String[] args) {
        if (controller.getDataController().getTreeMap().isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        int sum_of_height = 0;
        int average_of_height = 0;
        for (Person i: controller.getDataController().getTreeMap().values()) {
            sum_of_height+=i.getHeight();
        }
        average_of_height = sum_of_height/controller.getDataController().getTreeMap().size();
        System.out.println("среднее значение роста: " + average_of_height);
    }
    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
