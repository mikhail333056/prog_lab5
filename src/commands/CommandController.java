package commands;

import dataController.DataController;
import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 * A class that implements the basic functionality of all specified commands
 */
public class CommandController {

    private final DataController dataController;
    private final ArrayList<Command> allCommands = new ArrayList<>();
    public final int MAX_COMMANDS = 12;
    private final ArrayList<Command> commandHistory = new ArrayList<>();

    public ArrayList<Command> getAllCommands () {
        return allCommands;
    }

    public CommandController (final String path) {
        dataController = new DataController(path);
        initCommands();
        listen();
    }

    private void listen () {
        Scanner scanner = new Scanner(System.in);
        String[] args; // 0 аргумент - имя команды
        while (true) {
            System.out.print("$ ");
            args = scanner.nextLine().split(" ");
            args[0] = args[0].toLowerCase();
            invoke(parseCommand(args[0]), args);
        }
    }
    private void addCommandToHistory (final Command command) {
        if (commandHistory.size() == MAX_COMMANDS)
            commandHistory.remove(0);
        commandHistory.add(command);
    }
    public ArrayList<Command> getCommandHistory() {
        return commandHistory;
    }

    public void invoke (final Command command, final String[] args) {
        if (command == null) {
            System.out.println("Неизвестная команда. Используйте help для вывода списка команд.");
            return;
        }
        try {
            command.checkArgs(this, args);
        } catch (MissingArgumentException e) {
            System.out.println("Отсутствуют нужные аргументы: "+e.getMessage()+".");
            return;
        } catch (IncorrectArgumentException e) {
            System.out.println("Некорректные аргументы команды: "+e.getMessage()+".");
            return;
        }
        addCommandToHistory(command);
        command.execute(this, args);
    }

    public Command parseCommand (final String name) {
        for (Command i: allCommands) {
            if (i.getName().equals(name))
                return i;
        }
        return null;
    }

    private void initCommands () {
        allCommands.add(new HelpCommand());
        allCommands.add(new InfoCommand());
        allCommands.add(new ShowCommand());
        allCommands.add(new InsertCommand());
        allCommands.add(new RemoveKeyCommand());
        allCommands.add(new SaveCommand());
        allCommands.add(new UpdateCommand());
        allCommands.add(new ClearCommand());
        allCommands.add(new ExecuteScriptCommand());
        allCommands.add(new ExitCommand());
        allCommands.add(new ReplaceIfLowerCommand());
        allCommands.add(new RemoveLowerKeyCommand());
        allCommands.add(new RemoveGreaterKeyCommand());
        allCommands.add(new AverageOfHeightCommand());
        allCommands.add(new MaxByNameCommand());
        allCommands.add(new FilterLessThanLocationCommand());
        allCommands.add(new RemoveGreaterCommand());
    }
    public DataController getDataController () {
        return dataController;
    }
    // help

}