package valueobjects;

/**
 * Unter-Klasse zur Repr‰sentation der Kunden eines Accounts.
 */

public class Kunde extends Account {

	// Attribute zur Beschreibung des Kunden

	private String strasse;
	private int plz;
	private String wohnort;
	private Warenkorb warenkorb = new Warenkorb();

	/**
	 * Konstruktor
	 * 
	 * @param name
	 *            Kundenname
	 * @param passwort
	 *            Kundenpasswort
	 * @param accnummer
	 *            Accoutnnummer
	 * @param strasse1
	 *            Strasse
	 * @param plz1
	 *            Postleitzahl
	 * @param ort
	 *            Wohnort
	 */

	public Kunde(String name, String passwort, int accnummer, String strasse1, int plz1, String ort) {
		super(name, passwort, accnummer);
		this.strasse = strasse1;
		this.plz = plz1;
		this.wohnort = ort;
	}

	/**
	 * Methode zum Auflisten der Kundendaten
	 * 
	 */

	public String toString() {

		return ("Kunde:\n  " + getName() + " \n  " + strasse + "\n " + plz + " " + wohnort);
	}

	// Getter und Setter

	/**
	 * Methode zum Abrufen der Postleitzahl
	 * 
	 * @return plz Postleitzahl
	 */

	public int getPlz() {
		return plz;
	}

	/**
	 * Methode zum Setzen der Postleitzahl
	 * 
	 * @param plz
	 *            Postleitzahl
	 */

	public void setPlz(int plz) {
		this.plz = plz;
	}

	/**
	 * Methode zum Abrufen der Straﬂe
	 * 
	 * @return Straﬂe
	 */

	public String getStrasse() {
		return strasse;
	}

	/**
	 * Methode zum Setzen der Straﬂe
	 * 
	 * @param strasse
	 *            Straﬂe
	 */

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	/**
	 * Methode zum Abrufen des Wohnortes
	 * 
	 * @return wohnort Wohnort
	 */

	public String getWohnort() {
		return wohnort;
	}

	/**
	 * Methode zum Setzen des Wohnortes
	 * 
	 * @param wohnort
	 *            Wohnort
	 */

	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}

	/**
	 * Methode zum Abrufen des Warenkorbs
	 * 
	 * @return warenkorb Warenkorb
	 */

	public Warenkorb getWarenkorb() {
		return warenkorb;
	}

	/**
	 * Methode zum Setzen des Warenkorbs
	 * 
	 * @param warenkorb
	 *            Warenkorb
	 */

	public void setWarenkorb(Warenkorb warenkorb) {
		this.warenkorb = warenkorb;
	}
}