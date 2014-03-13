package hr.fer.zemris.java.tecaj.hw1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Rectangle class that calculate rectangle's area and perimeter.
 * Class contains one public static method and no public fields.
 * @author Nikola Sekulić
 * @version 1.0
 */
public class Rectangle {

	/**
	 * Calculate rectangle's area and perimeter, and writes results on console.
	 * User can define width and height of rectangle through command line arguments,
	 * or through standard input.
	 * @param args Arguments from command line.
	 */
	public static void main(String[] args) {

		double width = 0;
		double height = 0;

		if (args.length == 2) {

			width = Double.parseDouble(args[0]);
			height = Double.parseDouble(args[1]);

			if (width < 0.0) {
				System.out.println("Width is negative.");
				width = getParameter("Width");
			}
			if (height < 0.0) {
				System.out.println("Height is negative.");
				height = getParameter("Height");
			}
		} else if (args.length == 0) {

			width = getParameter("Width");
			height = getParameter("Height");

		} else {
			System.out.println("Invalid number of arguments was provided.");
			return;
		}


		String widthStr = Double.toString(width);
		String heightStr = Double.toString(height);
		String area = Double.toString(width * height);
		String perimiter = Double.toString(2 * (width + height));

		String output = "You have specified rectangle with width " + widthStr
				+ " and height " + heightStr + ". Its area is " + area
				+ " and its perimiter is " + perimiter + ".";

		System.out.println(output);

	}

	/**
	 * Method read one positive number from standard input.
	 * If user writes negative number or just press enter,
	 * method will ask user again for number.
	 * @param parameterName Name of parameter. Used only for info outputs on standard output.
	 * @return Number read from standard input
	 */
	private static double getParameter(String parameterName) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new BufferedInputStream(System.in)));

		String doubleStr = "";
		double parameter = -1;

		try {

			while (parameter < 0) {

				System.out.print("Please provide "
						+ parameterName.toLowerCase() + ": ");

				doubleStr = reader.readLine();
				if (doubleStr == null) {
					System.exit(0);
				} else {
					doubleStr = doubleStr.trim();
				}

				if (doubleStr.isEmpty()) {
					System.out.println("Nothing was given.");
					continue;
				}

				parameter = Double.parseDouble(doubleStr);

				if (parameter < 0) {
					System.out.println(parameterName + " is negative.");
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return parameter;
	}

}
