package DataMethod;

import java.io.File;

public class CalculateOSX extends Convert {

	
	
	
	
	// FIlE DEFINITION


	
	
	
	public static File source = new File("./Data/movie20_.txt"); // also see readme.txt
	static File log = new File("./Data/log.txt");
	
	
	
	
	
	// ANZAHL FILME IN DATEI "source"

	
		static int moviez = 20;
	
	
	
	// DATES FOR MEHTOD 8- "Zeitfenster" - Zwsichen DATE1 und DATE2

	//static long date1 = toUnixTimeStamp("2001-01-01"); 
	//static long date2 = toUnixTimeStamp("2002-01-01"); 

	static int windowSize = 1;
	
	
	
	
	public static void main(String[] args) {

		// Calculates method 1 to 7

		
		  for(int i=1;i<8;i++){
		  
		  System.out.println(); System.out.println("Now computing: Method "+i);
		  
		  

			File target = new File("./Data/movielens/method"+i+".txt"); //Temp File for Predictions
		  
		  
		  Prediction.exec(i,target);
		 
		  }
		 

		
		
		//Prediction.exec(7);
		
		
		
		
		// SINGLE CALCULATOR
	
		
	
	//	Prediction.exec(1);
		
			
		
		
		
		
		
		
		
		
		
	
	}

}
