package ua.fraglabtest.utils;

import java.util.Objects;

/**
 * Class for Naming Convention implementation.
 */
public class NameManager {
    private static NameManager instance;

    private NameManager() {
    }

    public static NameManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new NameManager();
        }
        return instance;
    }

    /**
     * The simplest logic of this class make names to upper case.
     * Advanced logic could quote/unquote names, check names for forbidden characters or even replace them.
     * @param name written by user
     * @return canonical name with naming convention applying.
     */
    public String getCanonicalName(String name) {
        return name.toUpperCase();
    }
}
