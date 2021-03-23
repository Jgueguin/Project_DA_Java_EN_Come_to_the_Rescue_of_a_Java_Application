package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Simple brute force implementation
 *
 * @author jgueguin
 * @version 1.1
 * @see ISymptomReader2
 */
public class ReadSymptomDataFromFile2 implements ISymptomReader2 {

	private String filepath;

	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile2(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @return
	 * @throws IOException e
	 */

	@Override
	public Map<String, Integer> GetSymptoms() throws IOException {

		Map<String, Integer> collection = new TreeMap<>(); // collection to save symptoms and associated occurences
		Set<String> nameSymptom = new TreeSet<>(); // list containing unique name for each symptom

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {

					// if collection already contains a symptom then occurence of the symptom  = occurence +1
					if (collection.containsKey(line)) {

						int nbrePresent = collection.getOrDefault(line, 0);
						collection.replace(line, nbrePresent + 1);

						// else collection doesn't contain any symptom and collection add symptom and its occurence = 1 , and symptom name is added into list
					} else {
						collection.put(line, 1);
						nameSymptom.add(line);
					}
					line = reader.readLine();
				}
				reader.close();

			} catch (IOException e) {

				// message in cas of error
				e.printStackTrace();
			}
		} else {

			System.out.println("pas de fichier");
		}

		// Console output of the result
		nameSymptom.forEach(name -> {
			System.out.println(name + ": " + collection.get(name));

		});

		// output generation
		FileWriter writer = new FileWriter("result.out");

		//write of the symptom name and associated occurence in output file
		nameSymptom.forEach(name -> {
			try {
				writer.write(name + ":" + collection.get(name) + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		//closure of the output file
		writer.flush();
		writer.close();

		return collection;
	}
}
