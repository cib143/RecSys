package DataMethod;

import java.io.File;

public class CalculateWIN extends Convert {

	
	
	
	
	// FIlE DEFINITION

	public static File source = new File("./data/movielens_2.txt"); // also see readme.txt
	static File log = new File("./Data/log.txt");
	
	public static File target = new File("./Data/movielens_linreg.txt"); //Temp File for Predictions
	
	
	
	// ANZAHL FILME IN DATEI "source"

	
		static int moviez = 3952;
	
	
	
	// DATES FOR MEHTOD 8- "Zeitfenster" - Zwsichen DATE1 und DATE2

	//static long date1 = toUnixTimeStamp("2001-01-01"); 
	//static long date2 = toUnixTimeStamp("2002-01-01"); 

	static int windowSize = 1;
	
	
	
	
	public static void main(String[] args) {

		// Calculates method 1 to 7

		
	/*	  for(int i=1;i<8;i++){
		  
		  System.out.println(); System.out.println("Now computing: Method "+i);
		  
		  Prediction.exec(i);
		 
		  }
	*/	 

		
		
		//Prediction.exec(7);
		
		
		
		
		// SINGLE CALCULATOR
	
		
	
		Prediction.exec(7);
		
	
		
		
		
	
	}

}
