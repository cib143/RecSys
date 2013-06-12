package DataMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convert {

	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public static void toDate(double unix_time) {

		Date date = new Date();
		date.setTime((long) unix_time * 1000);

		System.out.println(date);

	}

	public static long toUnixTimeStamp(String input) {

		Date date = new Date();
		try {
			date = df.parse(input);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return date.getTime() / 1000L;
	}

	public static void main(String[] args) throws ParseException {

		toDate(1115935200);

	}

	public static void replace(File file, String old, String neu, File target,
			boolean write) {

		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader

					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile

				// Eine Zeile der Datei in -file-

				zeile = zeile.replaceAll(old, neu);
				System.out.println(zeile);

				if (write = true) {
					Writer.writestring(zeile, target);
				}

			}

			b.close(); // closes reader
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}

	public static void addrow(File file, double zuzahl, File target) {

		/*
		 * Fügt einem Datensatz eine neue Reihe mit fester Zahl an
		 */

		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader

					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile

				zeile = zeile + "," + zuzahl;
				// System.out.println(zeile);

				Writer.writestring(zeile, target);

			}

			b.close(); // closes reader
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}

	public static void addrow_single(File file, double zuzahl, int movieID,
			File target) {

		/*
		 * Fügt einem Film aus dem Datensatz eine Spalte an.
		 */

		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader

					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile

				String[] splitResult = zeile.split(","); // –> splitten an den
															// Kommata

				if (Integer.parseInt(splitResult[0]) == movieID) {

					zeile = zeile + "," + zuzahl;
					// System.out.println("Writing: "+zeile);

					Writer.writestring(zeile, target);

				}
			}

			b.close(); // closes reader
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}

	public static void addrow_random(File file, File target) {

		String zeile = "";
		try {

			BufferedReader b = new BufferedReader( // Init new reader

					new FileReader(file)); // File to read
			while ((zeile = b.readLine()) != null) { // Liest Zeile für Zeile

				// Eine Zeile der Datei in -file-

				// Zufallszahl erzeugen
				int zuzahl = (int) ((Math.random()) * 5 + 1);

				zeile = zeile + "," + zuzahl;
				// System.out.println(zeile);

				Writer.writestring(zeile, target);
			}

			b.close(); // closes reader
		}

		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}

}
