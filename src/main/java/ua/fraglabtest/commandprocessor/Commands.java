package ua.fraglabtest.commandprocessor;

public enum Commands {
    CREATE_TABLE("createtable"),
    ADD_COLUMN("addcolumn"),
    DELETE_TABLE("deletetable"),
    UNKNOWN_COMMAND("");

    private String commandTest;

    Commands(String commandTest) {
        this.commandTest = commandTest;
    }

    public static Commands getCommand(String commandTest) {
        for (Commands command : values()) {
            if (command.commandTest.equals(commandTest)) {
                return command;
            }
        }
        return UNKNOWN_COMMAND;
    }
}
