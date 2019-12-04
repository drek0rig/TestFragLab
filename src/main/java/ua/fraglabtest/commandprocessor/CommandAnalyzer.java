package ua.fraglabtest.commandprocessor;

import java.util.Objects;

/**
 * Class parse and analyze commands prepared in JS websocket message.
 */
public class CommandAnalyzer {
    //Could create with additional options in constructor if needed.
    private static DataManager dataManager;

    public static void init() {
        dataManager = new DataManager();
    }

    public static void exit() {
        dataManager.close();
    }

    public static void analyzeCommand(String command) {
        Objects.requireNonNull(command);
        String[] splitedInput = command.split(",");
        executeCommand(Commands.getCommand(splitedInput[0]), splitedInput);
    }

    private static void executeCommand(Commands command, String[] inputArgs) {
        switch (command) {
            case CREATE_TABLE:
                dataManager.createTable(inputArgs[1]);
                break;
            case ADD_COLUMN:
                dataManager.addColumnToExistingTable(inputArgs[1]);
                break;
            case DELETE_TABLE:
                dataManager.dropTable(inputArgs[1]);
                break;
            default: {
                throw new IllegalStateException("Unknown command...");
            }
        }
    }
}
