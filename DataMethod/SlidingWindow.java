package DataMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class SlidingWindow extends CalculateOSX {

	/*
	 * 
	 * 
	 * 
	 * 
	 */

	// System.out.println(countMovies(new File("./Data/movie20_.txt"), 1));

	@SuppressWarnings("unused")
	private static void buildArray(Integer[][] daten, int movieID) {

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

	private static int countMovies(File file, int filmId) {

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

	private static int countMovies(Integer[][] data) {

		return data.length;

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

	@SuppressWarnings("unused")
	private static void plotArray(Integer[][] daten) {

		for (int i = 0; i < countMovies(source, 1); i++) {
			System.out.println(daten[i][0] + " " + daten[i][1] + " "
					+ daten[i][2] + " " + daten[i][3]);
		}
	}

	private static LinkedList<Integer> getLists(Integer[][] daten,
			int lengthOfList) {

		LinkedList<Integer> yList = new LinkedList<Integer>();

		for (int c = 0; c < lengthOfList; c++) {

			yList.add(daten[c][2]);

		}

		return yList;

	}

	public static int getAvgTimeWindow(LinkedList<Integer> List,
			int sizeOfTimeWindow) {

		int av = 0;
		int c = 0;

		// for the first movie the avg is 3

		if (List.size() == 0) {
			return 3;
		}
		if (List.size() < sizeOfTimeWindow) {
			sizeOfTimeWindow = List.size();
		}

		for (int i = 0; i < sizeOfTimeWindow; i++) {

			// System.out.println("WINDOWSIZE= "+sizeOfTimeWindow);

			av = av + List.getLast();
			List.removeLast();
			c++;

			// System.out.print("AV="+av);
			// System.out.println(" C="+c);

		}

		return av / c;

	}

	@SuppressWarnings("unused")
	private static int getAvgOfList(LinkedList<Integer> yList) {

		int av = 0;
		int c = yList.size();

		// for the first movie the avg is 3
		if (c == 0) {
			return 3;
		}

		for (int i = 0; i < c; i++) {

			av = av + yList.getFirst();
			yList.removeFirst();
		}

		return av / c;

	}

	public static void calculateAvgInTimeWindow(File target) {

		for (int mId = 1; mId < moviez + 1; mId++) {

			System.out.println("mId= " + mId);

			Integer[][] daten = new Integer[countMovies(source, mId)][4];

			TextReader.readSingleFilmToArray(daten, source, mId);
			sortOnArray(daten);

			System.out.println(daten.length);

			for (int indexOfMovies = 0; indexOfMovies < countMovies(daten); indexOfMovies++) {

				LinkedList<Integer> List = getLists(daten, indexOfMovies);

				Writer.writestring(
						daten[indexOfMovies][0] + "," + daten[indexOfMovies][1]
								+ "," + daten[indexOfMovies][2] + ","
								+ daten[indexOfMovies][3] + ","
								+ getAvgTimeWindow(List, windowSize), target);

			}

			System.out.println(countMovies(source, mId));

		}

	}

	public static void main(String[] args) {

	}

}
