package DataMethod;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

//for timestamp
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Writer {

	// an "Absatz"
	private static final String LINE = System.getProperty("line.separator");
	// date format
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public static void writestring(String string) {

		try {
			// Zieldatei
			File file = new File("./data/netflix_.txt");
			FileWriter fw = new FileWriter(file, true); // false = †berschreiben
														// der Datei
			fw.write(string);
			fw.write(LINE);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writestring(String string, File target) {

		try {
			FileWriter fw = new FileWriter(target, true); // false =
															// †berschreiben
			fw.write(string);
			fw.write(LINE);
			fw.flush();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeDouble(double x, File target) {

		try {
			FileWriter fw = new FileWriter(target, true); // false =
															// †berschreiben
			// fw.write(x);
			fw.write(LINE);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readwriter(String bewe, int movie) {
		String zeile = "";
		try {
			BufferedReader b = new BufferedReader(new FileReader(
					"/Users/Chrissi/Desktop/software projekt datenbank/training_set/mv_"
							+ bewe + ".txt"));
			// 1.Zeile Ÿberspringen
			b.readLine();
			while ((zeile = b.readLine()) != null) { // liest zeilenweise aus
														// Datei
				System.out.println(movie + "," + zeile);

				writestring(movie + "," + zeile); // Schreibt Ausgabe
			}
			b.close();
		}

		catch (IOException e) {
			System.out.println("Fehler: " + e.toString());
		}

	}

	public static void makeTimestamp(File source, File target) {

		delete(target);

		System.out.println("please wait!");

		String zeile = "";
		try {

			// Quelldatei
			BufferedReader b = new BufferedReader(new FileReader(source));

			while ((zeile = b.readLine()) != null) { // liest zeilenweise aus
														// Datei

				String temp = zeile.substring(0, zeile.length() - 10);

				try {

					Writer.writestring(
							temp
									+ String.valueOf(timestamp(getSingleRow(
											zeile, 3))), target);

					// System.out.println(temp +
					// String.valueOf(timestamp(getSingleRow(
					// zeile, 3))));

				} catch (ParseException e) {

					e.printStackTrace();
				}

			}

			// closes Stream
			b.close();
		}

		catch (IOException e) {
			System.out.println("Fehler: " + e.toString());
		}

	}

	public static long timestamp(String arg) throws ParseException {

		return df.parse(arg).getTime() / 1000L;
	}

	public static String getNull(int zahl) {

		DecimalFormat def = new DecimalFormat("0000000");
		// System.out.println(df.format(zahl));

		return def.format(zahl);

	}

	public static void getrow(String filer, int row) {

		String fileName = filer;
		File file = new File(fileName);

		try {
			Scanner inputStream = new Scanner(file);
			double sum = 0;
			int count = 0;

			while (inputStream.hasNext()) {

				String data = inputStream.next();
				String[] values = data.split(",");
				int rate = Integer.parseInt(values[0]);

				sum += rate;
				count++;

				System.out.println("Rate:" + rate + " C:" + count + " SUM:"
						+ sum);
			}
			inputStream.close();

			// System.out.println("Durchschnitt = " + (sum / count));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void changeCul(File file, int row) {

		try {
			Scanner inputStream = new Scanner(file);

			while (inputStream.hasNext()) {

				String data = inputStream.next();
				String[] values = data.split(",");

				String correct = new String(values[1] + "," + values[0] + ","
						+ values[2] + "," + values[3]);

				System.out.println(correct);

				writestring(correct, new File("./Data/movielens_2"));

			}
			inputStream.close();

			// System.out.println("Durchschnitt = " + (sum / count));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getSingleRow(String zeile, int row) {

		String result = new String();
		Scanner inputStream = new Scanner(zeile);

		String data = inputStream.next();
		String[] values = data.split(",");
		result = values[row];
		inputStream.close();

		return result;

	}

	public static void delete(File target) {

		if (target.exists()) {
			target.delete();

			System.out.println(target + " was deleted");

		}

		else
			System.out.println("File not found!");

	}

	public static void main(String[] args) {

	}

}
