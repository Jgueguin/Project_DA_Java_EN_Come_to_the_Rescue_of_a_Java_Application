package com.hemebiotech.analytics;

import java.io.IOException;

/**
 * Main program to read a txt file and to print the numbers of symptoms in a file and on console
 *
 * @author jgueguin
 * @version 1.1
 */

public class AnalyticsCounter {

	// path and file name defined as constants
		static String pathNameFile = "Project02Eclipse/src/symptoms.txt";

	public static void main(String args[]) throws IOException {

		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile(pathNameFile);

		PrintSymptomDataToFile output = new PrintSymptomDataToFile(file.GetSymptoms());

		output.printFile();


	}
}
