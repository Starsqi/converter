package org.rsavenkov;

public class MeasurementExtractor {
    private String knownMeasurementPattern = "\\b\\s*=\\s*\\b|\\s+";
    private String unknownMeasurementPattern = "\\b\\s*=\\s*\\W+\\s*\\b|\\s+";

    public MeasurementPair extractKnownMeasurement(String pairFromSystemIn){
        String[] knownMeasurementPairs = pairFromSystemIn.split(knownMeasurementPattern);
        return new MeasurementPair(
            new Measurement(knownMeasurementPairs[1], Double.parseDouble(knownMeasurementPairs[0])),
            new Measurement(knownMeasurementPairs[3], Double.parseDouble(knownMeasurementPairs[2]))
        );
    }

    public MeasurementPair extractUnknownMeasurement(String pairFromSystemIn) {
        String[] unknownMeasurementPairs  = pairFromSystemIn.split(unknownMeasurementPattern);
        return new MeasurementPair(
            new Measurement(unknownMeasurementPairs[1], Double.parseDouble(unknownMeasurementPairs[0])),
            new Measurement(unknownMeasurementPairs[2], null)
        );
    }
}
