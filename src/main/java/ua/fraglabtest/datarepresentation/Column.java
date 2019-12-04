package ua.fraglabtest.datarepresentation;

import ua.fraglabtest.utils.NameManager;

import java.util.Objects;

/**
 * Class represent metadata object COLUMN in TABLE.
 */
public class Column {
    private String name;
    private String type;
    private Object defaultValue;

    public void setType(String type) {
        this.type = type;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public Column(String name, String type) {
        this(name, type, null);
    }

    public Column(String name, String type, Object defaultValue) {
        this.name = NameManager.getInstance().getCanonicalName(name);
        this.type = type;
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return name.equals(column.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}