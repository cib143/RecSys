package DataMethod;

import java.io.File;

public class CalculateOSX extends Convert {

	
	
	
	
	// FIlE DEFINITION


	
	
	
	public static File source = new File("./Data/netflix_small.txt"); // also see readme.txt
	static File log = new File("./Data/log.txt");
	
	
	
	
	
	// ANZAHL FILME IN DATEI "source"

	
		static int moviez = 6760;
	
	
	
	// DATES FOR MEHTOD 8- "Zeitfenster" 


	static int windowSize = 200;
	
	
	
	
	public static void main(String[] args) {

		// Calculates method 1 to 8, 8 mit TimeWindows = 200

		
		  for(int i=1;i<9;i++){
		  
		  System.out.println(); System.out.println("Now computing: Method "+i);
		  
		  

			File target = new File("./Data/netflix/method"+i+".txt"); //Temp File for Predictions
		  
		  
		  Prediction.exec(i,target);
		 
		  }
		 

		
		
		//Prediction.exec(7);
		
		
		
		
		// SINGLE CALCULATOR
	
		
	
	//	Prediction.exec(1);
		
			
		
		
		
		
		
		
		
		
		
	
	}

}
