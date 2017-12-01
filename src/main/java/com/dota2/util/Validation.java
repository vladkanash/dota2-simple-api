package com.dota2.util;

public class Validation {

    public static void checkIsTrue(boolean expr, final String msg) {
        checkArguments(!expr, msg);
    }

    public static void checkNotNull(final Object obj) {
        checkNotNull(obj, "ERROR: " + obj + "is null");
    }

    public static void checkNotNull(final Object obj, final String msg) {
        checkArguments(obj == null, msg);
    }

    private static void checkArguments(final boolean predicate, final String msg) {
        if (predicate) {
            throw new IllegalArgumentException(msg);
        }
    }
}
