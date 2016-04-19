package valueobjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Klasse zur Repräsentation des Warenkorbs.
 */

public class Warenkorb {

	// Verwaltung des Warenkorbbestands als Liste
	// Als Implementierung der Liste dient Hashmap
	// enthät Artikel und Integer

	private HashMap<Artikel, Integer> inhalt = new HashMap<Artikel, Integer>();

	/**
	 * Konstruktor
	 * 
	 */

	public Warenkorb() {

	}

	/**
	 * Methode zum Einfuegen eines Artikels in den Warenkorb
	 * 
	 * @param a
	 *            Artikel, der ausgewählt wurde
	 * @param anzahl
	 *            gewünschte Anzahl des Artikels
	 */

	public void einfuegen(Artikel a, int anzahl) {
		//bevor artikel kaufen: pruefe ob massenartik. oder ...
		inhalt.put(a, anzahl);
	}

	/**
	 * Methode zum Loeschen eines Artikels im Warenkorb
	 * 
	 * @param a
	 *            Artikel, der ausgewählt wurde
	 */

	public void loeschen(Artikel a) {
		inhalt.remove(a);
	}

	/**
	 * Methode zum Leeren des Warenkorbs
	 * 
	 */

	public void leeren() {
		inhalt.clear();
	}

	/**
	 * Methode zum Abrufen des Inhalts
	 * 
	 * @return inhalt Warenkorbinhalt abrufen
	 */
	public HashMap getInhalt() {
		return inhalt;
	}

	/**
	 * Methode zum füllen des Warenkorbs
	 * 
	 * @param Inhalt
	 *            Warenkorb füllen
	 */
	public void setWarenkorbInhalt(HashMap Inhalt) {
		this.inhalt = Inhalt;
	}

	public void wirdGekauft() {
		// TODO Auto-generated method stub

	}
}