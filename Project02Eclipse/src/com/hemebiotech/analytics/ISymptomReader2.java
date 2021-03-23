package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 *
 * The implementation does not need to order the list
 *
 * @author jgueguin
 * @version 1.1
 */

public interface ISymptomReader2 {
	/**
	 * If no data is available, return an empty "Map"
	 *
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	Map<String,Integer> GetSymptoms () throws IOException;
}


