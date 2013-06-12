package DataMethod;

import java.io.*;

public class TextReader {

	public static void read(String file) {

		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader

					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile fŸr Zeile

				System.out.println(zeile);
			}

			b.close(); // closes reader
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}
	
	
	
	
	public static void readSingleFilmToArray(Integer[][] daten,File source,int movieID) {
		
		
		 

		int c = 0;
		String zeile = "";

		try {

			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(source)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile fŸr Zeile
				String[] splitResult = zeile.split(","); // Ð> splitten an den
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
	
	
	
	

}
