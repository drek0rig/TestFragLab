package ua.fraglabtest.datarepresentation;

import ua.fraglabtest.utils.NameManager;

import java.util.ArrayList;

/**
 * Class simulate schema in virtual database.
 */
public class SchemaInMemory extends ArrayList<Table> {
    public void drop(String tableName) {
        String canonicalName = NameManager.getInstance().getCanonicalName(tableName);
        this.stream().filter(table -> table.getName().equals(canonicalName)).forEach(this::remove);
    }

    /**
     * For example get any table.
     * @return first table.
     */
    public Table getTable() {
        return this.stream().findFirst().get();
    }

    public void writeToHardDrive() {
        //To file or db saving logic.
    }
}
