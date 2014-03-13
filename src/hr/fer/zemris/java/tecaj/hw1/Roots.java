package hr.fer.zemris.java.tecaj.hw1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Class Roots computes all roots of given complex number.
 * Class contains one public static method and no public fields.
 * @author Nikola Sekulić
 * @version 1.0
 *
 */
public class Roots {

	/**
	 * Computes all n roots of given complex number,
	 * and writes them on standard output. Number and root are provided
	 * in String array. First element is real part of complex number,
	 * second imaginary part and third is required root.
	 * @param args Array of String.
	 */
	public static void main(String[] args) {
		
		if(args.length != 3) {
			System.err.println("Program need 3 arguments!");
			System.exit(-1);
		}
		
		double realPart = Double.parseDouble(args[0]);
		double imaginaryPart = Double.parseDouble(args[1]);
		int root = Integer.parseInt(args[2]);
		
		if(root <= 1) {
			System.err.println("Root has to be greater then 1!");
			System.exit(-2);
		}
		
		double absoluteValue = Math.sqrt(realPart*realPart + imaginaryPart*imaginaryPart);
		double argument = Math.atan2(imaginaryPart, realPart);
		
		
		double absoluteValueOfRoot = Math.pow(absoluteValue, 1.0/root);
		double argumentOfRoot = argument / root;
		
		System.out.printf("You requested calculation of %d. roots. Solutions are:\r\n", root);
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("#.######", dfs);
		
		
		for(int i = 0; i < root; i++) {
			double newArgument = argumentOfRoot +  i * ((2 * Math.PI) / root);
			double realPartOfRoot = absoluteValueOfRoot * Math.cos(newArgument);
			double imaginatyPartOfRoot = absoluteValueOfRoot * Math.sin(newArgument);
			String realStr = df.format(realPartOfRoot);
			String imgStr = df.format(Math.abs(imaginatyPartOfRoot));
			
			String operator = "+";
			if(imaginatyPartOfRoot < 0) {
				operator = "-";
			}
			
			System.out.printf("%d) %s " + operator + " %si\r\n", (i+1), realStr, imgStr);			
			
		}
		

	}

}
