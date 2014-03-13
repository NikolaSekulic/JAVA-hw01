package hr.fer.zemris.java.tecaj.hw1;

/**
 * Class NumberDecomposition calculates decomposition of number onto prime factors.
 * Class contains one public static method and no public fields.
 * @author Nikola Sekulić
 * @version 1.0
 */
public class NumberDecomposition {

	/**
	 * Class NumberDecomposition calculates decomposition
	 * of provided number onto prime factors and writes
	 * that factors on standard output, each in new line.
	 * @param args String array, first element is number for decomposition.
	 */
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.err.println("Program needs 1 argument!");
			System.exit(-1);
		}
		
		int number = Integer.parseInt(args[0]);
		
		if(number <= 0) {
			System.err.println("Argument has to be greater then 0.");
			System.exit(-2);
		}	
		
		int[] primeNumbers = new int[number];
		primeNumbers[0] = 2;
		
		int primeNumbersFound = 1;
		int primeCandidate = 3;
		
		
		
		System.out.println("You requested decomposition of number " + number
				+ " onto prime factors. Here they are:");
		
		int numberOfFactors = 0;
		while(number > 1) {
			
			int factor = primeNumbers[primeNumbersFound - 1];
			while((number % factor) == 0) {
				numberOfFactors += 1;
				System.out.printf("%d. %d\r\n", numberOfFactors, factor);
				number /= factor;
			}
			
			
			boolean primeNumberFound = false;
			while(!primeNumberFound) {
				
				boolean isPrime = true;
				
				for(int i = 0; i < primeNumbersFound; i++) {
					if(primeCandidate % primeNumbers[i] == 0) {
						isPrime = false;
						break;
					}
				}
				
				if (isPrime) {
					primeNumbers[primeNumbersFound] = primeCandidate;
					primeNumbersFound += 1;
					primeNumberFound = true;
				}
				
				primeCandidate += 2;
			}		
			
		}

	}

}
