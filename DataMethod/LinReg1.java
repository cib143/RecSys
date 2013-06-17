package DataMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LinReg1 extends CalculateOSX {

	/*
	 * 
	 * 
	 * 
	 * 
	 */

	

	// System.out.println(countMovies(new File("./Data/movie20_.txt"), 1));

	private static void fillArray(Integer[][] daten, int movieID) {

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

			

				}
			}

			b.close(); // closes reader
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}

	public static int countMovies(File file, int filmId) {

		int c = 0;
		String zeile = "";

		try {

			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile fŸr Zeile
				String[] splitResult = zeile.split(","); // Ð> splitten an den
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

		for (int i = 0; i < daten.length; i++) {
			System.out.println(daten[i][0] + " " + daten[i][1] + " "
					+ daten[i][2] + " " + daten[i][3]);
		}
	}

	private static void getLinReg(Integer[][] daten, int mId, File target) {

		LinkedList<Integer> xList = new LinkedList<Integer>();
		LinkedList<Integer> yList = new LinkedList<Integer>();

		for (int c = 1; c < daten.length; c++) {

			xList.add(c);
			yList.add(daten[c][2]);

			// System.out.println(daten[c][0]+","+daten[c][1]+","+daten[c][2]+","+daten[c][3]+","+getLinReg(xList,yList,mId));

			String toWrite = daten[c][0] + "," + daten[c][1] + ","
					+ daten[c][2] + "," + daten[c][3] + ","
					+ getLinReg(xList, yList, mId);

			Writer.writestring(toWrite, target);

		}

	}

	private static int getLinReg(LinkedList<Integer> xList,
			LinkedList<Integer> yList, int mId) {

		int count = xList.size();
		int[] xArray = new int[count];
		int[] yArray = new int[count];
		int i = 0;
		for (Integer value : xList) {
			xArray[i] = value;
			++i;
		}
		i = 0;
		for (Integer value : yList) {
			yArray[i] = value;
			++i;
		}
		double xSumme = 0;
		double ySumme = 0;
		for (i = 0; i < xArray.length; ++i) {
			xSumme += xArray[i];
			ySumme += yArray[i];
		}
		// Durchschnitt x & y
		double xMean = xSumme / (double) xArray.length;
		double yMean = ySumme / (double) yArray.length;

		// System.out.println("x Durchschnitt : " + xMean);
		// System.out.println("y Durchschnitt : " + yMean);

		double m1 = 0;
		double m2 = 0;
		for (i = 0; i < xArray.length; ++i) {
			m1 += xArray[i] * yArray[i];
			m2 += xArray[i] * xArray[i];
		}

		m1 -= ((double) xArray.length) * xMean * yMean;
		m2 -= ((double) xArray.length) * xMean * xMean;

		double m = m1 / m2;
		double n = yMean - m * xMean;

		// System.out.println("Steigung= "+m);

		// System.out.println("Geradengleichung : " + m + " * x + " + n);
		if (xList.isEmpty()) {
			System.out.println(mId);
			System.out.println("EEE");
			return 3;
		}
		int next = (int) (m * (xList.getLast() + 1) + n);

		
		if (next <= 0) return 1;
		else if (next > 5) return 5;
		
		return next;

	}
	
	
	
	public static void execLinReg(File target){
		
		
		int mId = 1;

		while (mId <= moviez) {

			System.out.println(mId);

			Integer[][] daten = new Integer[countMovies(source, mId)][4];
			
			
			

			fillArray(daten, mId);
			sortOnArray(daten);
			
			//plotArray(daten);
			getLinReg(daten, mId, target);

			mId++;
		}
		
		
	}

	public static void main(String[] args) {

		
		

		
		
	
		
		}

	}


