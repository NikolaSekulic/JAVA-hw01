package hr.fer.zemris.java.tecaj.hw1;

/**
 * Class with implementation of list. Elements of list are Strings.
 * Class has four methods for list manipulation and has not public field.
 * Methods are velicinaListe,  ubaci, ispisiListu and sortirajListu
 * @author Nikola Sekulić
 * @version 1.0
 *
 */
public class ProgramListe {
	
	
	static class CvorListe {
		CvorListe sljedeci;
		String podatak;
	}

	public static void main(String[] args) {
		
		CvorListe cvor =  null;
		
		cvor = ubaci(cvor, "Jasna");
		cvor = ubaci(cvor, "Ana");
		cvor = ubaci(cvor, "Ivana");
		
		
		System.out.println("Ispisujem listu uz originalni poredak:");
		ispisiListu(cvor);
		
		cvor = sortirajListu(cvor);
		
		System.out.println("Ispisujem listu nakon sortiranja:");
		ispisiListu(cvor);
		
		int vel = velicinaListe(cvor);
		System.out.println("Lista sadrzi elemenata: " + vel);
		
	}
	
	/**
	 * Gets number of elements in list.
	 * Complexity of method is O(n).
	 * @param cvor First element of list.
	 * @return Number of elements in list.
	 */
	static int velicinaListe(CvorListe cvor) {
		if (cvor == null) {
			return 0;
		}
		return 1 + velicinaListe(cvor.sljedeci);
	}
	
	/**
	 * Puts String in list.
	 * New element is added at the beginning of the list.
	 * Complexity of method is O(1).
	 * @param prvi First element of list.
	 * @param podatak String that has to be added in list.
	 * @return First element of list with new element.
	 */
	static CvorListe ubaci(CvorListe prvi, String podatak) {
		CvorListe noviCvor = new CvorListe();
		noviCvor.podatak = podatak;
		noviCvor.sljedeci = prvi;
		return noviCvor;
	}
	
	/**
	 * Writes list on standard output.
	 * Each element is written in new line.
	 * @param cvor First element of list.
	 */
	static void ispisiListu(CvorListe cvor) {
	
		System.out.println("Ispis liste: ");
		if(cvor == null) {
			System.out.println("Lista je prazna!");
		}
		
		CvorListe trenutni = null;
		int numberOfElement = 1;
		for(trenutni = cvor; trenutni != null; trenutni = trenutni.sljedeci) {
			System.out.println("\t" + numberOfElement + ". element: " + trenutni.podatak);
			numberOfElement += 1;
		}
		
	}
	
	/**
	 * Sorts list in ascending order.
	 * String comparison is not case sensitive.
	 * Complexity of method is O(n^2).
	 * @param cvor First element of list.
	 * @return first element of sorted list.
	 */
	static CvorListe sortirajListu(CvorListe cvor) {
		if(cvor == null) {
			return cvor;
		}
		
		int velicina = velicinaListe(cvor);
		
		for(int i = 0; i < velicina; i++) {
			CvorListe trenutni = null;
			for(trenutni = cvor; trenutni.sljedeci != null; trenutni = trenutni.sljedeci) {
				if(trenutni.podatak.compareToIgnoreCase(trenutni.sljedeci.podatak) > 0) {
					String tempString = trenutni.podatak;
					trenutni.podatak = trenutni.sljedeci.podatak;
					trenutni.sljedeci.podatak = tempString;
				}
			}
		}		
		
		return cvor;
	}

}
