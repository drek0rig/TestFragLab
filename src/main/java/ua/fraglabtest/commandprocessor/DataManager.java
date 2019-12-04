package ua.fraglabtest.commandprocessor;

import ua.fraglabtest.datarepresentation.Column;
import ua.fraglabtest.datarepresentation.SchemaInMemory;
import ua.fraglabtest.datarepresentation.Table;

/**
 * Class manage commands in our virtual database.
 */
public class DataManager implements AutoCloseable {
    private SchemaInMemory schemaInMemory = new SchemaInMemory();

    public void createTable(String tableName) {
        schemaInMemory.add(Table.create(tableName));
    }

    public void addColumnToExistingTable(String columnName) {
        Table tableFromSchema = schemaInMemory.getTable();
        tableFromSchema.addColumn(new Column(columnName, null));
    }

    public void dropTable(String tableName) {
        schemaInMemory.drop(tableName);
    }

    @Override
    public void close() {
        schemaInMemory.writeToHardDrive();
        schemaInMemory.clear();
    }
}
