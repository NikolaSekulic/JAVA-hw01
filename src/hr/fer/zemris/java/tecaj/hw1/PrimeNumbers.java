package hr.fer.zemris.java.tecaj.hw1;

/**
 * Class PrimeNumbers calculates first n prime numbers.
 * Class contains one public static method and no public fields.
 * @author Nikola Sekulić
 * @version 1.0
 */
public class PrimeNumbers {
	

	/**
	 * Calculates first n prime numbers
	 * and writes them on standard output.
	 * @param args Number of prime numbers represented as String.
	 */
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.err.println("Program needs 1 argument!");
			System.exit(-1);
		}
		
		int numberOfPrimeNumbers = Integer.parseInt(args[0]);
		
		if(numberOfPrimeNumbers <= 0) {
			System.err.println("Argument has to be greater then 0.");
			System.exit(-2);
		}		
		
		int[] primeNumbers = new int[numberOfPrimeNumbers];
		primeNumbers[0] = 2;
		
		int numbersFound = 1;
		int candidate = 3;
		
		System.out.println("You requested calculation of " + numberOfPrimeNumbers +" prime numbers. Here they are:");
		System.out.printf("%d. %d\r\n", 1, primeNumbers[0]);
		
		while(numbersFound < numberOfPrimeNumbers) {
			
			boolean isPrime = true;
			
			for(int i = 0; i < numbersFound; i++) {
				if(candidate % primeNumbers[i] == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				primeNumbers[numbersFound] = candidate;
				numbersFound += 1;
				System.out.printf("%d. %d\r\n", numbersFound, candidate);
			}
			
			candidate += 2;
		}

	}

}
