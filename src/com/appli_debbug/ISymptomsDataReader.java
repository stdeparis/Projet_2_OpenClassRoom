package com.appli_debbug;

import java.util.List;
import java.util.TreeMap;



public interface ISymptomsDataReader {


	/**
	 * if no data is available, return an emty List
	 * @return a raw listing of all symptoms obtained fromd data source, duplicates are possible/probable
	 */
	
	    List<String> GetSymptoms ();
	    
	   /**
	    * If no data is available, return an empty Map 	    * 
	    * @param listeSymptmsnteger
	    * @return a sorted Map of all Symptoms whith their number of occurency
	    */
	 TreeMap<String, Integer> sortingSymptomsData(List<String> listeDESSymptoms);
	 
	 /**
	  *Save the results in a file
	 * @param sortedMapOfSymtoms 
	  */
 void fileWriterData(TreeMap<String, Integer> sortedMapofSymptoms);
}
