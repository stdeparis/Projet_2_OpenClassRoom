package com.appli_debbug;

import java.util.List;
import java.util.TreeMap;


public class Main {

	
		private static List<String> listeDesSypmtoms;

		public static void main(String[] args) {
			String fichier_a_lire = "symptom.txt";
			String fichier_final = "results.out";
			SymptomsDataReader lecteur = new SymptomsDataReader();
			lecteur.readSymptomsDataFromFile(fichier_a_lire, fichier_final);
			List<String> listeDesSymtoms = lecteur.GetSymptoms();
			TreeMap<String, Integer> symptomsTrieEtCompte = lecteur.sortingSymptomsData(listeDesSymtoms);
			lecteur.fileWriterData(symptomsTrieEtCompte);
		}

	}


