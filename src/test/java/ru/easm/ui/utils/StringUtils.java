package ru.easm.ui.utils;

import java.util.Objects;

public class StringUtils {

    public static String toStringOrNull(final Object object) {
        return Objects.isNull(object) ? "null" : String.valueOf(object);
    }
}