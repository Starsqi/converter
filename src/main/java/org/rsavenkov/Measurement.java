package org.rsavenkov;

public class Measurement {
    private final String type;
    private final Double value;

    public Measurement(String type, Double value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }

    public boolean isKnown() {
        return value != null;
    }

    @Override
    public String toString() {
        if (isKnown()){
        return value + " " + type;
        } else {
            return "?" + " " + type;
        }
    }
}
