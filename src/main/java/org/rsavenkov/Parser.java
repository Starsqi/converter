package org.rsavenkov;

public abstract class Parser {
    public static Object parse(double d) {
        return (d % 1 == 0) ? (int) d : d;
    }
}
