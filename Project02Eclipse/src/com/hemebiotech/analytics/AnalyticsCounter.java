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
	static String path = "Project02Eclipse/src/";
	static String nameFile = "symptoms.txt";

	public static void main(String args[]) throws IOException {

		// ->>> Object creation with Call of ReadSymptomDataFromFile2  with file name and path as parameters
		ReadSymptomDataFromFile2 file = new ReadSymptomDataFromFile2(path + nameFile);

		// ->> output of the results
		System.out.println(file.GetSymptoms());
	}
}
