package com.hemebiotech.analytics;

import java.io.IOException;

/**
 * Main program to read a txt file and to sort the numbers of symptoms
 *
 * @author jgueguin
 * @version 1.1
 */

public class AnalyticsCounter {

	// path and file name defined as constants
		static String pathNameFile = "Project02Eclipse/src/symptoms.txt";

	public static void main(String args[]) throws IOException {

		//		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile(null);
		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile(pathNameFile);

		// ->> print results in 'results.out' file and on console
		PrintSymptomDataToFile output = new PrintSymptomDataToFile(file.GetSymptoms());
		output.printFile();


	}
}
