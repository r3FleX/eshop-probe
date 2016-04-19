package valueobjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Klasse zur Repr�sentation des Warenkorbs.
 */

public class Warenkorb {

	// Verwaltung des Warenkorbbestands als Liste
	// Als Implementierung der Liste dient Hashmap
	// enth�t Artikel und Integer

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
	 *            Artikel, der ausgew�hlt wurde
	 * @param anzahl
	 *            gew�nschte Anzahl des Artikels
	 */

	public void einfuegen(Artikel a, int anzahl) {
		//bevor artikel kaufen: pruefe ob massenartik. oder ...
		inhalt.put(a, anzahl);
	}

	/**
	 * Methode zum Loeschen eines Artikels im Warenkorb
	 * 
	 * @param a
	 *            Artikel, der ausgew�hlt wurde
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
	 * Methode zum f�llen des Warenkorbs
	 * 
	 * @param Inhalt
	 *            Warenkorb f�llen
	 */
	public void setWarenkorbInhalt(HashMap Inhalt) {
		this.inhalt = Inhalt;
	}

	public void wirdGekauft() {
		// TODO Auto-generated method stub

	}
}