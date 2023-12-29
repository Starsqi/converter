package org.rsavenkov;

public class MeasurementPair {
    private Measurement first;
    private Measurement second;

    public MeasurementPair(Measurement first, Measurement second) {
        this.first = first;
        this.second = second;
    }

    public boolean isSecondKnown() {
        return second.isKnown();
    }

    public Measurement getFirst() {
        return first;
    }

    public Measurement getSecond() {
        return second;
    }

    public void setFirst(Measurement first) {
        this.first = first;
    }

    public void setSecond(Measurement second) {
        this.second = second;
    }
    

    @Override
    public String toString() {
        if (second.isKnown()) {
            return first.toString() + " = " + second.toString();
        }
        else {
            return "Conversion not possible.";
        }
    }
}
