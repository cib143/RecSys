package DataMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



	// TIMESTAMP ERSTELLEN




public class Test extends Calculate {

	private static void fillArray(Integer[][] daten) {

		int c = 0;
		String zeile = "";

		try {

			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(source)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile
				String[] splitResult = zeile.split(","); // –> splitten an den
															// Kommata

				
					c++;

					daten[c - 1][0] = Integer.parseInt(splitResult[0]);
					daten[c - 1][1] = Integer.parseInt(splitResult[1]);
					daten[c - 1][2] = Integer.parseInt(splitResult[2]);
					daten[c - 1][3] = Integer.parseInt(splitResult[3]);

					// System.out.println(daten[c-1][0]+" "+daten[c-1][1]+" "+daten[c-1][2]+" "+daten[c-1][3]);

				}
			

			b.close(); // closes reader
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}
	
	
	public static int countRatings(File file){
		
		
		

		int c = 0;
		String zeile = "";

		try {

			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(source)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile
				

				
					c++;


					
				}
			

			b.close(); // closes reader
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
		return c;
		
	}
	
	private static void plotArray(Integer[][] daten) {

		for (int i = 0; i < daten.length; i++) {
			System.out.println(daten[i][0] + " " + daten[i][1] + " "
					+ daten[i][2] + " " + daten[i][3]);
		}
	}
	
	
	public static void main(String[] args) {
		
		
		
		System.out.println(countRatings(source));
		
		Integer[][] daten = new Integer[countRatings(source)][4];
		
		
		//fillArray(daten);
		System.out.println(daten.length);
	}

}