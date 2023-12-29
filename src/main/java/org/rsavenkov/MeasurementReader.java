package org.rsavenkov;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeasurementReader implements AutoCloseable {
    private Scanner sc;
    private final MeasurementExtractor measurementExtractor;

    public MeasurementReader(InputStream inputStream) {
        this.sc = new Scanner(inputStream);
        this.measurementExtractor = new MeasurementExtractor();
    }

    public List<MeasurementPair> readKnownMeasurements() {
        List<MeasurementPair> listKnownMeasurements = new ArrayList<>();
        while (true) {
            String readPair = sc.nextLine();

            if (readPair.isEmpty()) {
                break;
            } else {
                listKnownMeasurements.add(measurementExtractor.extractKnownMeasurement(readPair));
            }
        }

        return listKnownMeasurements;
    }

    public List<MeasurementPair> readUnknownMeasurements() {
        List<MeasurementPair> listUnknownMeasurements = new ArrayList<>();
        while (true) {
            String readPair = sc.nextLine();

            if (readPair.isEmpty()) {
                break;
            } else {
                listUnknownMeasurements.add(measurementExtractor.extractUnknownMeasurement(readPair));
            }
        }

        return listUnknownMeasurements;
    }

    @Override
    public void close() throws Exception {
        sc.close();
    }
}
