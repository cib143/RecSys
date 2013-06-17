package DataMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Auswertung extends CalculateOSX {

	/*
	 * Datei
	 * 
	 * Bewerung - Prediction --> Summieren & teilen durch Anzahl
	 */

	public static long toUnixTimeStamp(Date date) {

		return date.getTime() / 1000L;
	}

	public static double rmse, mae;

	public static void getError(File file) {

		double c = 0;
		double sum = 0, dummsum = 0;

		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader

					new FileReader(file)); // File to read

			b.readLine();
			while ((zeile = b.readLine()) != null) { // Liest Zeile fŸr Zeile
				String[] splitResult = zeile.split(","); // Ð> splitten an den Kommata														
				// Echte Bewertung
				double err1 = Double.parseDouble(splitResult[2]);
				// Vorhersage
				double err2 = Double.parseDouble(splitResult[4]);
				//Just whole star ratings!
				err2 = Math.round(err2);
				// Summe
				c++;			
				// Calculate RMSE-SUM
				sum = sum + Math.abs((err1 - err2));
				// Calculate MAE-SUM
				dummsum = dummsum + Math.pow((err1 - err2), 2);				
			}
			b.close(); // closes reader

			// Calculate RMSE
			rmse = (Math.sqrt(sum / c));

			System.out.println(rmse);
			
			
			// Calculate MAE
			mae = sum / c;
			System.out.println(mae);
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}

	public static void writeLog(int c, File target) {

		Date date = new Date();

		System.out.println("Method: " + c + " is Done!");

		Auswertung.getError(target);

		Writer.writestring(
				toUnixTimeStamp(date) + "::" + c + "::" + Auswertung.rmse
						+ "::" + Auswertung.mae + "::" + source.getName(), log);

		// System.out.println("RMSE: "+Math.sqrt(Auswertung.getError(target)));
		System.out.println("Logfile is stored to " + log);

	}
	
	
	public static void addCounter (int movieID){
		
		
		System.out.println("FŸgt die Anzahl der Bewertungen je Film zu");
		
		
		for(int x = 1; x<=moviez;x++){
			
			
			
		int counter = (int)LinReg1.countMovies(source, x);	
			
			
		Convert.addrow_single(new File("./Data/movielens/method"+movieID+".txt"), counter, x, new File("./Data/movielens/method"+movieID+"_.txt"));
		
		}
		
		
		new File("./Data/movielens/method"+movieID+".txt").delete();
		System.out.println("Done");
		
		
	}
	
	
	public static void calcRMSEtoFile(int movie){
		
		
		double c = 0;
		double sum = 0, dummsum = 0;

		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader

					new FileReader("./Data/movielens/method1_.txt")); // File to read

			b.readLine();
			while ((zeile = b.readLine()) != null) { // Liest Zeile fŸr Zeile
				String[] splitResult = zeile.split(","); // Ð> splitten an den Kommata														
				
				if(Integer.parseInt(splitResult[0]) == movie){
				
				// Echte Bewertung
				double err1 = Double.parseDouble(splitResult[2]);
				// Vorhersage
				double err2 = Double.parseDouble(splitResult[4]);
				//Just whole star ratings!
				err2 = Math.round(err2);
				// Summe
				c++;			
				// Calculate RMSE-SUM
				sum = sum + Math.abs((err1 - err2));
				// Calculate MAE-SUM
				dummsum = dummsum + Math.pow((err1 - err2), 2);	
				
				}	
			}
			b.close(); // closes reader

			// Calculate RMSE
			rmse = (Math.sqrt(sum / c));
			
			

			System.out.println(rmse);
			
			
			
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}	
		
		
		
	
	public static void addRMSEtoFile(int c){
		
		
		
		
			
			for(int i = 1;i<moviez+1;i++){
			calcRMSEtoFile(i);
			Convert.addrow_single(new File("./Data/movielens/method"+c+"_.txt"), rmse, i, new File("./Data/movielens/method"+c+"_withRMSE"));	
			
			
			
			}
			new File("./Data/movielens/method"+c+"_.txt").delete();	
	}
		
		
	
	
	

	public static void main(String[] args) {

	

	
	}
}

