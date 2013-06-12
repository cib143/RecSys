package DataMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.jfree.data.statistics.Regression;

public class LinReg extends Calculate {

	/*
	 * 
	 * 
	 * 
	 * 
	 */

	public static double[][] temp = new double[1][1];

	// System.out.println(countMovies(new File("./Data/movie20_.txt"), 1));

	private static void fillArray(Integer[][] daten, int movieID) {

		int c = 0;
		String zeile = "";

		try {

			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(source)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile
				String[] splitResult = zeile.split(","); // –> splitten an den
															// Kommata

				if (Integer.parseInt(splitResult[0]) == movieID) {
					c++;

					daten[c - 1][0] = Integer.parseInt(splitResult[0]);
					daten[c - 1][1] = Integer.parseInt(splitResult[1]);
					daten[c - 1][2] = Integer.parseInt(splitResult[2]);
					daten[c - 1][3] = Integer.parseInt(splitResult[3]);

					// System.out.println(daten[c-1][0]+" "+daten[c-1][1]+" "+daten[c-1][2]+" "+daten[c-1][3]);

				}
			}

			b.close(); // closes reader
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}

	private static int countMovies(File file, int filmId) {

		int c = 0;
		String zeile = "";

		try {

			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile
				String[] splitResult = zeile.split(","); // –> splitten an den
															// Kommata
				if (Integer.parseInt(splitResult[0]) == filmId) {
					c++;

				}
			}
			b.close(); // closes reader
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
		return c;
	}

	// Sortiert Array nach einer bestimmten Spalte (hier Spalte3)

	private static void sortOnArray(Integer[][] ar) {
		Arrays.sort(ar, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] int1, Integer[] int2) {
				Integer numOfKeys1 = int1[3];
				Integer numOfKeys2 = int2[3];
				return numOfKeys1.compareTo(numOfKeys2);
			}
		});

	}

	private static void plotArray(Integer[][] daten) {

		for (int i = 0; i < countMovies(source, 1); i++) {
			System.out.println(daten[i][0] + " " + daten[i][1] + " "
					+ daten[i][2] + " " + daten[i][3]);
		}
	}

	private static void getLinReg(Integer[][] daten, int mId) {

	

	}

	private static void getLinReg(double[][] base) {
		

		double[] result = Regression.getOLSRegression(base);

		System.out.println("y = "+result[0]+" + "+result[1]+"x");
		
		

	}
	

	public static void addLine(int zeile, Integer[][] source, double[][] target){
		
		
		target[0][0] = zeile;
		target[0][1] = source[zeile-1][2];
		
		
		
		
		
		
		
		
		
	}
	
	
	

	
	
	
	
	public static void execLinReg(){
		
		
		int mId = 1;
		
		// Array initialisieren --> 5 Spalten!!
		Integer[][] daten = new Integer[countMovies(source, mId)][5];
		
		
		
		// Filme zählen im Array!!!
		
		
			
		
		
		// Filme in Array stecken
		   fillArray(daten, mId);
		// Array nach Zeit sortieren
		   sortOnArray(daten);
		   
		  System.out.println(daten.length);
		  
	
		   
		   
		// Vorhersagen mittel Regression in Array
		// Kompletten Film in txt speichern
		
		
		
		

		
		
	}

	public static void main(String[] args) {

		
	
		
		}

	}


