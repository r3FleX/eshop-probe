package valueobjects;

/**
 * Klasse zur Repräsentation der Massengutartikel.
 */

public class Massengutartikel extends Artikel {

	// Attribute zur Beschreibung der Massengutartikel
	private int packungsgroesse;

	/**
	 * Konstruktor
	 * 
	 * @param artname Artikelname
	 * @param artnr Artikelnummer
	 * @param artbestand
	 *            Artikelbestand
	 * @param artpreis
	 *            Artikelpreis
	 * @param packungsgroesse
	 *            Packungsgroesse
	 */

	public Massengutartikel(String artname, int artnr, int artbestand, float artpreis, int packungsgroesse) {
		super(artname, artnr, artbestand, artpreis);
		this.packungsgroesse = packungsgroesse;
	}

	/**
	 * 
	 * @param a
	 *            Massengutartikel
	 */

	public Massengutartikel(Massengutartikel a) {
		// Copy-Konstruktor
		this(a.getName(), a.getNummer(), a.getBestand(), a.getPreis(), a.packungsgroesse);
	}

	/**
	 * Methode zum Auflisten der Daten des Massengutartikels
	 */

	@Override
	public String toString() {
		return ("Artikelnummer: " + getNummer() + " / Artikelname: " + getName() + " / " + "Bestand: " + getBestand()
				+ " / " + "Packungsgroesse: " + packungsgroesse + " /" + "Preis pro Stueck: " + getPreis() + " " + '\u20ac');
	}

	// Getter und Setter

	/**
	 * Methode zum Abrufen der Packungsgröße
	 * 
	 * @return packungsgroesse Packungsgröße
	 */

	public int getPackungsgroesse() {
		return packungsgroesse;
	}

	/**
	 * Methode zum Setzen der Packungsgröße
	 * 
	 * @param packungsgroesse
	 *            Packungsgröße
	 */

	public void setPackungsgroesse(int packungsgroesse) {
		this.packungsgroesse = packungsgroesse;
	}
}