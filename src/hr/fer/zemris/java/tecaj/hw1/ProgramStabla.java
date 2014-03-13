package hr.fer.zemris.java.tecaj.hw1;


/**
 * Class with implementation of binary tree. Elements of tree are Strings.
 * Class has five methods for tree manipulation and has not public field.
 * Methods are sadrziPodatak, velicinaStabla, ubaci,
 * ispisiStablo and okreniPoredakStabla
 * @author Nikola Sekulić
 * @version 1.0
 *
 */
public class ProgramStabla {
	
	
	/**
	 * Element of the tree
	 * Contains string, reference on left child and right child.
	 */
	static class CvorStabla {
		CvorStabla lijevi;
		CvorStabla desni;
		String podatak;
	}


	
	public static void main(String[] args) {
		
		CvorStabla cvor = null;
			
		
		cvor = ubaci(cvor, "Jasna");
		cvor = ubaci(cvor, "Ana");
		cvor = ubaci(cvor, "Ivana");
		cvor = ubaci(cvor, "Anamarija");
		cvor = ubaci(cvor, "Vesna");
		cvor = ubaci(cvor, "Kristina");
		
		System.out.println("Ispisujem stablo inorder:");
		ispisiStablo(cvor);
		
		cvor = okreniPoredakStabla(cvor);
		
		System.out.println("Ispisujem okrenuto stablo inorder:");
		ispisiStablo(cvor);
		
		int vel = velicinaStabla(cvor);
		System.out.println("Stablo sadrzi elemenata: " + vel);
		
		boolean pronaden = sadrziPodatak(cvor, "Ivana");
		System.out.println("Trazeni podataka je pronaden: " + pronaden);

	}
	
	
	/**
	 * Checks if tree contains element with provided String.
	 * @param korijen Root element of the tree.
	 * @param podatak String that is checked in tree.
	 * @return True if tree contains string, false otherwise.
	 */
	static boolean sadrziPodatak(CvorStabla korijen, String podatak) {
		if(korijen == null) {
			return false;
		}
			
		if(korijen.podatak.equals(podatak)) {
			return true;
		}
		
		return (sadrziPodatak(korijen.lijevi, podatak) || sadrziPodatak(korijen.desni, podatak));
	}
	
	
	/**
	 * Gets number of element of tree.
	 * Complexity of method is O(n).
	 * @param cvor Root element of the three.
	 * @return Number of elements.
	 */
	static int velicinaStabla(CvorStabla cvor) {
		if(cvor ==  null) {
			return 0;
		}
		
		return 1 + velicinaStabla(cvor.lijevi) + velicinaStabla(cvor.desni);
	}
	
	
	/**
	 * Puts String in tree on the lowest level of tree possible.
	 * Root of the tree is considered the lowest level.
	 * Complexity of method is O(n).
	 * @param korijen
	 * @param podatak
	 * @return
	 */
	static CvorStabla ubaci(CvorStabla korijen, String podatak) {
				
		CvorStabla noviCvor = new CvorStabla();
		noviCvor.podatak = podatak;
		
		if(korijen == null) {
			korijen = noviCvor;
		} else {
			Lista lista = new Lista();
			dodajNaKrajListe(lista, korijen);
			
			while(true) {
				CvorStabla cvor = skiniCvorSaPocetkaListe(lista);
				
				if(cvor.lijevi == null) {
					cvor.lijevi = noviCvor;
					break;
				} else if (cvor.desni == null) {
					cvor.desni = noviCvor;
					break;
				} else {
					dodajNaKrajListe(lista, cvor.lijevi);
					dodajNaKrajListe(lista, cvor.desni);
				}
			}
		}
		
		return korijen;
	}
	
	
	/**
	 * Writes elements of the tree on standard output
	 * in inorder sequence.
	 * @param cvor Root element of the three.
	 */
	static void ispisiStablo(CvorStabla cvor) {
		if(cvor != null)  {
			ispisiStablo(cvor.lijevi);
			System.out.println(cvor.podatak);
			ispisiStablo(cvor.desni);
		}
	}
	
	/**
	 * Inverse order of the elements in tree.
	 * @param korijen Root element of the three.
	 * @return Root element of the three.
	 */
	static CvorStabla okreniPoredakStabla(CvorStabla korijen) {
		if(korijen == null) {
			return korijen;
		}
		
		CvorStabla tempCvor = korijen.lijevi;
		korijen.lijevi = korijen.desni;
		korijen.desni = tempCvor;
		
		korijen.lijevi = okreniPoredakStabla(korijen.lijevi);
		korijen.desni = okreniPoredakStabla(korijen.desni);
		
		return korijen;
	}
	
	
	/**
	 * Element of list.
	 * Element contains reference on next element in list,
	 * and element of tree.
	 * @author Nikola
	 *
	 */
	static class ElementListe {
		CvorStabla cvor;
		ElementListe sljedeci;
	}
	
	
	/**
	 * Linked list implementation.
	 * List has reference on first element in list,
	 * and last element in list.
	 */
	static class Lista {
		ElementListe pocetakListe;
		ElementListe krajListe;
	}
	
	/**
	 * Puts element at the end of list.
	 * Complexity of operation id O(1).
	 * @param lista List
	 * @param cvor Element
	 */
	static void dodajNaKrajListe(Lista lista, CvorStabla cvor) {
		
		ElementListe noviElement = new ElementListe();
		noviElement.cvor = cvor;
		
		if(lista.krajListe == null && lista.pocetakListe == null) {
			
			lista.krajListe = noviElement;
			lista.pocetakListe = noviElement;
			
		} else {
			
			lista.krajListe.sljedeci = noviElement;
			lista.krajListe = noviElement;
		}
	}
	
	/**
	 * Gets the element from the begin of list, and removes 
	 * it from list.
	 * Complexity of method is O(1).
	 * @param lista List of elements.
	 * @return First element in list.
	 */
	static CvorStabla skiniCvorSaPocetkaListe(Lista lista) {
		
		CvorStabla cvor = lista.pocetakListe.cvor;		
		lista.pocetakListe = lista.pocetakListe.sljedeci;
		if(lista.pocetakListe == null) {
			lista.krajListe = null;
		}
		
		return cvor;
	}
	
}
