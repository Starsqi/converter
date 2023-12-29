package org.rsavenkov;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        try (MeasurementReader mr = new MeasurementReader(System.in)) {
            List<MeasurementPair> knownMeasurementPairs = mr.readKnownMeasurements();
            List<MeasurementPair> unknownMeasurementPairs = mr.readUnknownMeasurements();

            MeasurementAnalyzer measurementAnalyzer = new MeasurementAnalyzer();

            for (MeasurementPair unknownPair  : unknownMeasurementPairs) {

                List<MeasurementPair> conclusion = new ArrayList<>();

                measurementAnalyzer.getConclusion(
                        unknownPair, knownMeasurementPairs, unknownPair.getFirst().getType(), 1, conclusion
                );

                for (MeasurementPair measurementPair : conclusion) {
                    System.out.println(measurementPair);
                }
            }
        }
    }
}