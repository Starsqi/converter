package org.rsavenkov;

import java.util.ArrayList;
import java.util.List;

public class MeasurementAnalyzer {

    public void getConclusion(
        MeasurementPair unknownPair,
        List<MeasurementPair> knownPairs,
        String knownMeasurementType,
        double needToFindValue,
        List<MeasurementPair> conclusion
    ) {
        double resultDigit = needToFindValue;

        if (unknownPair.isSecondKnown()) {
            return;
        } else if (knownMeasurementType.equals(unknownPair.getSecond().getType())) {
            resultDigit = resultDigit * unknownPair.getFirst().getValue();
            unknownPair.setSecond(new Measurement(unknownPair.getSecond().getType(), resultDigit));
            conclusion.add(unknownPair);
            return;
        }

        for (MeasurementPair knownPair : knownPairs) {
            if (knownMeasurementType.equals(knownPair.getFirst().getType())) {
                double tempResultDigit = (knownPair.getSecond().getValue() / knownPair.getFirst().getValue()) * resultDigit;
                String tempKeyValue = knownPair.getSecond().getType();

                List<MeasurementPair> newListOfValuePairs = new ArrayList<>(knownPairs);
                newListOfValuePairs.remove(knownPair);

                getConclusion(unknownPair, newListOfValuePairs, tempKeyValue, tempResultDigit, conclusion);
            } else if (knownMeasurementType.equals(knownPair.getSecond().getType())) {
                double tempResultDigit = (knownPair.getFirst().getValue() / knownPair.getSecond().getValue()) *
                    resultDigit;
                String tempKeyValue = knownPair.getFirst().getType();

                List<MeasurementPair> newListOfValuePairs = new ArrayList<>(knownPairs);
                newListOfValuePairs.remove(knownPair);

                getConclusion(unknownPair, newListOfValuePairs, tempKeyValue, tempResultDigit, conclusion);
            }
        }
    }
}
