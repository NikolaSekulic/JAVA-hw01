package hr.fer.zemris.java.tecaj.hw1;



/**
 * HofstadterQ class calculates nth Hofstadter's sequence number.
 * Class contains one public static method and has not public fields.
 * @author Nikola Sekulić
 * @version 1.0 *
 */
public class HofstadterQ {

	
	/**
	 * Method calculates nth Hofstadter's sequence number,
	 * and writes it on standard output.
	 * Complexity of method is O(n).
	 * @param args position in sequence represented as String
	 */
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.err.println("Number of arguments has to be 1!");
			System.exit(-1);
		}
		
		int number = Integer.parseInt(args[0]);
		
		if (number <= 0)  {
			System.err.println("Argument has to be greater then 0!");
			System.exit(-2);
		}
		
		long hofstadter = 1;
		
		
			
		if(number > 2) {
			long[] hofstadterQSequence = new long[number];
			hofstadterQSequence[0] = 1;
			hofstadterQSequence[1] = 1;
			
			for(int i = 2; i < number; i++) {
				hofstadterQSequence[i] =
						hofstadterQSequence[(int)((long)i - hofstadterQSequence[i-1])] +
						hofstadterQSequence[(int)((long)i - hofstadterQSequence[i-2])];
			}
			hofstadter = hofstadterQSequence[number - 1];
		}
		
		
		
		System.out.println("You requested calculation of " + number + ". "
				+ "number of Hofstadter's Q-sequence. The requested number is "
				+ hofstadter +". ");		
		

	}

}
