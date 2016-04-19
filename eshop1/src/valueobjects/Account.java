package valueobjects;

/**
 * Klasse zur Repräsentation der Accounts.
 */

public class Account {

	// Attribute zur Beschreibung des Accounts

	private int accountNr;
	private String accountname;
	private String accountpasswort;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 *            Name des Users
	 * @param passwort
	 *            Passwort
	 * @param accnummer
	 *            Accountnummer
	 */

	public Account(String name, String passwort, int accnummer) {
		this.accountname = name;
		this.accountpasswort = passwort;
		this.accountNr = accnummer;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account) {
			Account anderesAccount = (Account) obj;
			return this.accountname.equals(anderesAccount.accountname);
		}

		return false;
	}

	// Getter und Setter

	/**
	 * Methode zum Abrufen der Accountnummer
	 * 
	 * @return accountNr Accountnummer
	 */

	public int getAccountNr() {
		return accountNr;
	}

	/**
	 * Methode zum Setzen der Accountnummer
	 * 
	 * @param accountNr
	 *            Accountnummer
	 */

	public void setAccountNr(int accountNr) {
		this.accountNr = accountNr;
	}

	/**
	 * Methode zum Abrufen des Accountnamen
	 * 
	 * @return accountname Accoutname
	 */

	public String getName() {
		return accountname;
	}

	/**
	 * Methode zum Setzer des Accountnamen
	 * 
	 * @param name
	 *            Accoutnname
	 */

	public void setName(String name) {
		this.accountname = name;
	}

	/**
	 * Methode zum Abrufen des Passworts
	 * 
	 * @return accountpasswort
	 */

	public String getPasswort() {
		return accountpasswort;
	}

	/**
	 * Methode zum Setzen des Passworts
	 * 
	 * @param passwort
	 *            Accountpasswort
	 */

	public void setPasswort(String passwort) {
		this.accountpasswort = passwort;
	}
}