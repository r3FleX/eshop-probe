package valueobjects;

/**
 * Unter-Klasse zur Repr�sentation der Mitarbeiter eines Accounts.
 */

public class Mitarbeiter extends Account {

	/**
	 * Konstruktor
	 * 
	 * @param name
	 *            Mitarbeitername
	 * @param passwort
	 *            Mitarbeiternummer
	 * @param accnummer
	 *            Accountnummer
	 */

	public Mitarbeiter(String name, String passwort, int accnummer) {
		super(name, passwort, accnummer);
	}
}