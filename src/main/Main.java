package main;

import commands.CommandController;
import dataController.DataController;

public class Main {
    private static final String sysEnvironment = "TEST_VAR";

    public static String getSystemEnvironment() {
        return sysEnvironment;
    }

    public static String getFilePath() {
        return System.getenv(getSystemEnvironment());
    }
    public static void main(String[] args) {
        CommandController controller = new CommandController(getFilePath());
    }
}