package com.appli_debbug;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.hermebiotech.symptom;

public class SymptomsDataReader implements ISymptomsDataReader {
    
    
	private String filepath;
 
	private String outputpath;

	
 	public void readSymptomsDataFromFile (String filepath, String outputpath) {
 		
 		this.filepath = filepath;
 		this.outputpath = outputpath;
 	
 	}
 	
 	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
   if (filepath != null) {
   	try {
   		BufferedReader reader = new BufferedReader(new FileReader(this.filepath));
   		String line = reader.readLine();

   		while(line != null) {
   			
   			result.add(line);
   			line = reader.readLine();
   		}
   		reader.close();
   	} catch (IOException e) {
   		e.printStackTrace();
   	}
   }
		
		return result;
	}

    /**
     * 
     * 
     * 
     */
	public TreeMap<String, Integer> sortingSymptomsData(List<String> listeDesSymptoms) {
		TreeMap<String, Integer> symptomsTri =  new TreeMap<>();
		for (String unSymtom : listeDesSymptoms) {
			if (symptomsTri.containsKey(unSymtom)) {
				symptomsTri.put(unSymtom, symptomsTri.get(unSymtom) + 1);
			} else {
				symptomsTri.put(unSymtom, 1);
			}
		}
		return symptomsTri;
	}

	/**
	 * 
	 * 
	 */
	public void fileWriterData(TreeMap<String, Integer> map)  {
		try {
			FileWriter fw = new FileWriter(new File(this.outputpath));
			for (String key : map.keySet()) {
				fw.write(key + "=" + map.get(key) + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
