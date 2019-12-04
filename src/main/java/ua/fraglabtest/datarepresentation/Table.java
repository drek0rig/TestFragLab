package ua.fraglabtest.datarepresentation;

import ua.fraglabtest.utils.NameManager;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Table {
    private String name;
    private Set<Column> columns;

    public Table(String name, Set<Column> columns) {
        this.name = NameManager.getInstance().getCanonicalName(name);
        columns.forEach(this::initColumn);
    }

    private void initColumn(Column column) {
        if (Objects.isNull(columns)) {
            this.columns = new HashSet<>();
        }
        if (!this.columns.add(column)) {
            System.err.println(String.format("Column %s already exist in table %s.", column.getName(), name));
        }
    }

    public void addColumn(Column column) {
        initColumn(column);
    }

    public String getName() {
        return name;
    }

    public Set<Column> getColumns() {
        return columns;
    }

    /**
     * Method for Table class instance creation. For more advanced logic could use Factory or Builder patterns.
     *
     * @param newTableName name
     * @return new Table instance
     */
    public static Table create(String newTableName) {
        return new Table(newTableName, Collections.EMPTY_SET);
    }
}
