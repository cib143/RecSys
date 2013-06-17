package DataMethod;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Prediction extends CalculateOSX {

	static LinkedList<Double> xList = new LinkedList<Double>();
	static LinkedList<Double> yList = new LinkedList<Double>();
	static double next = 0;

	private static double get_average(File file) {
		int av = 0;
		float d = 0;
		int c = 0;
		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile
				c++;
				String[] splitResult = zeile.split(","); // –> splitten an den
															// Kommata
				av = av + Integer.parseInt(splitResult[2]); // Summe

			}
			d = (av / c);
			System.out.println(d);
			b.close(); // closes reader
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
		return d;
	}

	@SuppressWarnings("unused")
	private static double get_average_time(File file, double after,
			double before) {

		// Durchschnittswert innerhalb eines bestimmten Datums errechnen
		// - Daten (von, bis) übergeben?
		// - Jeweils für alle und einen Film?

		int av = 0;
		float d = 0;
		int c = 0;
		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile
				String[] splitResult = zeile.split(","); // –> splitten an den
															// Kommata
				if (Integer.parseInt(splitResult[3]) >= after
						&& Integer.parseInt(splitResult[3]) <= before) {
					av = av + Integer.parseInt(splitResult[2]); // Summe
					c++;
				}
			}
			d = (av / c);
			b.close(); // closes reader
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
		return d;
	}

	private static double get_average_each(File file, int filmId) {
		int av = 0;
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
					av = av + Integer.parseInt(splitResult[2]); // Summe
				}
			}
			b.close(); // closes reader
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
		return getAverage(filmId, av, c);
	}

	@SuppressWarnings("unused")
	private static double get_average_each_time(File file, int filmId,
			long date1, long date2) {
		int av = 0;
		int c = 0;
		String zeile = "";

		try {
			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile
				String[] splitResult = zeile.split(","); // –> splitten an den

				if (Integer.parseInt(splitResult[0]) == filmId
						&& Integer.parseInt(splitResult[3]) > date1
						&& Integer.parseInt(splitResult[3]) < date2) {
					c++;
					av = av + Integer.parseInt(splitResult[2]); // Summe
				}
			}
			b.close(); // closes reader
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
		return getAverage(filmId, av, c);
	}

	private static double get_median(File file) {
		int arrayLength = 0;
		double arrayMedian = 0;
		int currentIndex = 0;
		ArrayList<Double> zahlen = new ArrayList<Double>();
		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile
				String[] splitResult = zeile.split(","); // –> splitten an den
															// Kommata
				zahlen.add(Double.parseDouble(splitResult[2]));
			}
			Collections.sort(zahlen);
			arrayLength = zahlen.size();
			if (arrayLength % 2 != 0) {
				currentIndex = ((arrayLength / 2) + 1);
				arrayMedian = zahlen.get(currentIndex - 1);
			} else {
				int indexOne = (arrayLength / 2);
				int indexTwo = arrayLength / 2 + 1;
				double arraysSum = zahlen.get(indexOne - 1)
						+ zahlen.get(indexTwo - 1);
				arrayMedian = arraysSum / 2;
			}
			b.close(); // closes reader
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
		return arrayMedian;

	}

	@SuppressWarnings("resource")
	private static double get_median_each(File file, int filmId) {

		int arrayLength = 0;
		double arrayMedian = 0;
		int currentIndex = 0;
		ArrayList<Double> zahlen = new ArrayList<Double>();
		String zeile = "";

		try {
			BufferedReader b = new BufferedReader( // Init new reader
					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile
				String[] splitResult = zeile.split(","); // –> splitten an den
															// Kommata
				if (Integer.parseInt(splitResult[0]) == filmId) {
					zahlen.add(Double.parseDouble(splitResult[2])); // Bewrtungen
				}
			}
			Collections.sort(zahlen);
			arrayLength = zahlen.size();
			if (zahlen.size() == 0) {
				return 3;
			}
			if (arrayLength % 2 != 0) {
				currentIndex = ((arrayLength / 2) + 1);
				arrayMedian = zahlen.get(currentIndex - 1);
			} else {
				int indexOne = (arrayLength / 2);
				int indexTwo = arrayLength / 2 + 1;
				double arraysSum = zahlen.get(indexOne - 1)
						+ zahlen.get(indexTwo - 1);
				arrayMedian = arraysSum / 2;
			}
			b.close(); // closes reader
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
		return arrayMedian;
	}


	private static double getAverage(int filmId, int av, int c) {
		double d;
		if (c == 0) {
			d = 3;
			System.out.println("NO RATING FOR MOVIE " + filmId);
		} else {
			d = (av / c);
		}
		return d;
	}

	public static void test(String file) {

		String example = "1,822109,5,2005-05-13";
		String[] splitResult = example.split(","); // –> splitten an den
													// Leerzeichen

		System.out.println(splitResult[0]);
		System.out.println(splitResult[1]);
		System.out.println(splitResult[2]);
		System.out.println(splitResult[3]);

	}

	public static void exec(int c, File target) {

		// to start with a clean target file
		if (target.exists()) {
			target.delete();
		}

		System.out.println("Old hallo.txt deleted");
		System.out.println("Please wait!");

		if (c == 1) {
			// Zufallszahl hinzufügen
			addrow_random(source, target);
		}

		else if (c == 2) {
			// Feste Zahl hinzufügen
			addrow(source, 3, target);
		}

		else if (c == 3) {
			// Durschnitt hinzufügen
			addrow(source, get_average(source), target);
		}

		else if (c == 4) {
			// Durchschnitt pro Film hinzufügen
			for (int i = 1; i < moviez + 1; i++) {
				addrow_single(source, get_average_each(source, i), i, target);
			}
		}

		else if (c == 5) {
			// Median gesamt
			addrow(source, get_median(source), target);
		}

		else if (c == 6) {
			// Median pro Film
			for (int i = 1; i < moviez + 1; i++) {
				addrow_single(source, get_median_each(source, i), i, target);
			}
		}

		else if (c == 7) {
			// LinReg
			
			
			LinReg1.execLinReg(target);
			
			
			
			
		}

		
		else if (c == 8) {
			// Calculate with time window
			
			SlidingWindow.calculateAvgInTimeWindow(target);
			
			}
		
		
		
		
		else
			System.out.println("Error");

		// writes logfile
		Auswertung.writeLog(c, target);
		
	}

	public static void main(String[] args) {
	}
}
