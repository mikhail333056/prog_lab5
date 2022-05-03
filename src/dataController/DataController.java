package dataController;

import data.Person;

import java.util.TreeMap;

/**
 * A class that implements the TreeMap collection
 */
public class DataController {
    private final TreeMap<Integer, Person> treeMap;
    private final ConsoleController consoleController;
    private final FileController fileController;
    private final String path;

    public DataController (final String path) {
        this.path = path;
        treeMap = new TreeMap<>();
        consoleController = new ConsoleController(this);
        fileController = new FileController(this, path);
        fileController.readCSVFile(path);
    }

    public String getPath() {
        return path;
    }

    public TreeMap<Integer, Person> getTreeMap() {
        return treeMap;
    }
    public void addPerson (final Person person) {
        treeMap.put(person.getId(), person);
    }
    public ConsoleController getConsoleController() {
        return consoleController;
    }

    public FileController getFileController() {
        return fileController;
    }
}