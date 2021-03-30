package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Print Symptom and its occurrences into file and on console
 *
 */

public class PrintSymptomDataToFile implements IReaderMap {

    private Map readMap;

    /**
     * @param readMap : collection which retrieves collection generated in ResdSymptomDataFromFile
     */
    public PrintSymptomDataToFile(Map readMap) {
        this.readMap = readMap;
    }

    /**
     *
     */

    @Override
    public void printFile() throws IOException {

        // output generation
        FileWriter writer = new FileWriter("result.out");

        //write of the symptom name and associated occurrence in output file and on console
        System.out.println("Symptoms   :  occurrences");
        writer.write("Symptoms   :  occurrences \n");

        readMap.forEach((name, Integer) -> {

            try {
                System.out.println(name + ": " + readMap.get(name));
                writer.write(name + ": " + readMap.get(name) + "\n");

            } catch (IOException e) {

                e.printStackTrace();
            }
        });

        writer.close();

        return;
    }


}