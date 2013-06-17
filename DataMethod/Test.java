package DataMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;







public class Test extends CalculateOSX {

	public static void read(String file) {

		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader

					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile

				String[] splitResult = zeile.split(",");
				
				
				if (Integer.parseInt(splitResult[1]) <= 300000) {
					

					Writer.writestring(zeile, new File("./Data/netflix_small.txt"));
		
					//System.out.println(zeile);

				}
		
				
				
				
			}

			b.close(); // closes reader
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}
	
	
	
	public static void main(String[] args) {
		
		
		
		read(new String("/Users/Chrissi/Desktop/software projekt datenbank/Quelldaten/netflix_ts.txt"));
		
		
		
		
		
		
		
		
		
		
	}

}