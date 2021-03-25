package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * The goal of this class is to read the contain of a file and to sort it
 * @author jgueguin
 * @version 1.1
 *
 * @see com.hemebiotech.analytics.ISymptomReader
 */


public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * @return
     */

    @Override
    public Map<String, Integer> GetSymptoms() throws IOException {

        Map<String, Integer> mapSymptoms = new TreeMap<>(); // collection to save symptoms and associated occurences

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();

            while (line != null) {

                if (mapSymptoms.containsKey(line)) {

                    int nbrePresent = mapSymptoms.getOrDefault(line, 0);
                    mapSymptoms.replace(line, nbrePresent + 1);

                } else {

                    mapSymptoms.put(line, 1);

                }

                line = reader.readLine();
            }
            reader.close();

        } catch (NullPointerException e) {
            System.out.println("NullPointerException Caught");
        }

        return mapSymptoms;
    }
}
