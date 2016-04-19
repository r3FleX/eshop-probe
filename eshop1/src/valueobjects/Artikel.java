package valueobjects;

import valueobjects.Artikel;

/**
 * Klasse zur Repräsentation der Artikel.
 */

public class Artikel {

	// Attribute zur Beschreibung der Artikel

	private String artname;
	private int bestand;
	private int nummer;
	private float preis;

	/**
	 * Konstruktor
	 * 
	 * @param artname
	 *            Artikelname
	 * @param artnr
	 *            Artikelnummer
	 * @param artbestand
	 *            Artikelbestand
	 * @param artpreis
	 *            Artikelpreis
	 */

	public Artikel(String artname, int artnr, int artbestand, float artpreis) {
		nummer = artnr;
		this.artname = artname;
		bestand = artbestand;
		preis = artpreis;

	}

	/**
	 * 
	 * 
	 * @param a
	 *            Artikel
	 */

	public Artikel(Artikel a) {
		// Copy-Konstruktor
		this(a.artname, a.nummer, a.bestand, a.preis);
	}

	/**
	 * Methode zum Auflisten der Artikelattribute
	 * 
	 */
	public String toString() {

		return ("Artikelnummer: " + nummer + " / Artikelname: " + artname + " / " + "Bestand: " + bestand + " / "
				+ "Preis: " + preis + " " + '\u20ac');
	}

	/**
	 * Methode zum Vergleichen der Artikelnummern
	 * 
	 */

	public boolean equals(Object andererArtikel) {
		if (andererArtikel instanceof Artikel)
			return ((nummer == ((Artikel) andererArtikel).nummer) && (artname
					.equals(((Artikel) andererArtikel).artname)));
		else
			return false;
	}

	// Getter und Setter

	/**
	 * Methode zum Abrufen der Artikelnummer
	 * 
	 * @return nummer Artikelnummer
	 */

	public int getNummer() {
		return nummer;
	}

	/**
	 * Methode zum Abrufen des Artikelnamen
	 * 
	 * @return artname Artikelname
	 */

	public String getName() {
		return artname;
	}

	/**
	 * Methode zum Abrufen des Artikelbestands
	 * 
	 * @return bestand Artikelbestand
	 */

	public int getBestand() {
		return bestand;
	}

	/**
	 * Methode zum Setzen des Artikelbestands
	 * 
	 * @param bestand
	 *            Artikelbestand
	 */

	public void setBestand(int bestand) {
		this.bestand = bestand;
	}

	/**
	 * Methode zum Abrufen des Preises
	 * 
	 * @return preis Artikelpreis
	 */

	public float getPreis() {
		return preis;
	}

	/**
	 * Methode zum Setzen des Preises
	 * 
	 * @param preis
	 *            Artikelpreis
	 */

	public void setPreis(float preis) {
		this.preis = preis;
	}

	/**
	 * Methode zum Abrufen der Packungsgröße
	 * 
	 * @return 0
	 */
	public int getPackungsgroesse() {
		return 0;
	}
}