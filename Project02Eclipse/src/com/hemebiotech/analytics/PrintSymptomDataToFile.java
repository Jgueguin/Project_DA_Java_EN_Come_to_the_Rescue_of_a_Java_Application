package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The goal of this class is to retrieve a collection generated by ReadSymptomDataFromFile class to print to a file and on console
 *
 * @author jgueguin
 * @version 1.0
 *
 * @see com.hemebiotech.analytics.IReaderMap
 */

public class PrintSymptomDataToFile implements IReaderMap {

    private Map readMap;

    /**
     * @param readMap : collection which retrieves collection generated by ReadSymptomDataFromFile
     */
    public PrintSymptomDataToFile(Map readMap) {
        this.readMap = readMap;
    }

    /**
     *
     */

    @Override
    public void printFile() throws IOException {

        FileWriter writer = new FileWriter("result.out");

        System.out.println("Symptoms   :  occurences");
        writer.write("Symptoms   :  occurences \n");

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