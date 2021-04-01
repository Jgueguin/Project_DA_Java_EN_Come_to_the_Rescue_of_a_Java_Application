package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Main program to read a txt file and to print the numbers of symptoms in a file and on console
 *
 * @author jgueguin
 * @version 2.0
 */

public class AnalyticsCounter {

    // path and file name defined as constants
    static String pathNameFile = "Project02Eclipse/src/symptoms.txt";

    public static void main(String args[]) throws IOException {

        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        analyticsCounter.processData();
    }

    // Process data method
    public void processData() throws IOException {

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(pathNameFile);
        Map<String, Integer> mapSymptoms = reader.getSymptoms();
        this.outputData(mapSymptoms);

    }

    // method to print results in a file and on console
    public void outputData(Map<String, Integer> mapSymptoms) throws IOException {
        // output generation
        FileWriter writer = new FileWriter("result.out");

        System.out.println("Symptoms   :  occurences");
        writer.write("Symptoms   :  occurences \n");

        mapSymptoms.forEach((name, Integer) -> {

            try {
                System.out.println(name + ": " + mapSymptoms.get(name));
                writer.write(name + ":" + mapSymptoms.get(name) + "\n");

            } catch (IOException e) {

                e.printStackTrace();

            }
        });

        writer.close();
    }


}


