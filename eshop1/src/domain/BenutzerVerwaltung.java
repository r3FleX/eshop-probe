package domain;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import persistence.FilePersistenceManager;
import persistence.PersistenceManager;

import valueobjects.Account;
import valueobjects.Kunde;
import valueobjects.Mitarbeiter;

import domain.exceptions.AccountExistiertBereitsException;
import domain.exceptions.AccountExistiertNichtException;


/**
 * Klasse zur Verwaltung von Accounts.
 * 
 */

public class BenutzerVerwaltung {

	private boolean loginStatus = false;

	// Verwaltung der Accounts als Liste
	// Als Implementierung der Liste dient ein Vektor
	private List<Account> accountBestand = new Vector<Account>();
	
	
	// Persistenz-Schnittstelle, die fuer die Details des Dateizugriffs
	// verantwortlich ist
	private PersistenceManager pm = new FilePersistenceManager();

	public BenutzerVerwaltung() {
		
	}

	
	/**
	 * Methode zum Einlesen der Kundendaten
	 * 
	 * @param datei Datei, die Accounts enthält
	 * @throws IOException
	 */
	
	public void liesKundendaten(String datei) throws IOException {
		// PersistenzManager fuer Lesevorgaenge oeffnen
		pm.openForReading(datei);

		Kunde einKunde;
		do {
			// Account-Objekt einlesen
			einKunde = pm.ladeKunde();
			if (einKunde != null) {
				// Account in Liste einfuegen
				try {
					KundeEinfuegen(einKunde);
				} catch (AccountExistiertBereitsException e1) {
					// Kann hier eigentlich nicht auftreten,
					// daher auch keine Fehlerbehandlung...
				}
			}
		} while (einKunde != null);

		// Persistenz-Schnittstelle wieder schlieﬂen
		pm.close();
	}

	
	/**
	 * Methode zum Einlesen der Mitarbeiterdaten
	 * 
	 * @param datei
	 * @throws IOException
	 */
	
	public void liesMitarbeiterdaten(String datei) throws IOException {
		// PersistenzManager fuer Lesevorgaenge oeffnen
		pm.openForReading(datei);

		Mitarbeiter einMitarbeiter;
		do {
			// Account-Objekt einlesen
			einMitarbeiter = pm.ladeMitarbeiter();
			if (einMitarbeiter != null) {
				// Account in Liste einf¸gen
				try {
					MitarbeiterEinfuegen(einMitarbeiter);
				} catch (AccountExistiertBereitsException e1) {
					// Kann hier eigentlich nicht auftreten,
					// daher auch keine Fehlerbehandlung...
				}
			}
		} while (einMitarbeiter != null);

		// Persistenz-Schnittstelle wieder schlieﬂen
		pm.close();

	}

	/**
	 * Methode zum Einfuegen eines Kunden-Accounts
	 *
	 * @param einKunde 
	 * @throws AccountExistiertBereitsException
	 */
	
	// Kunde einfuegen
	public void KundeEinfuegen(Kunde einKunde)
			throws AccountExistiertBereitsException {
		if (accountBestand.contains(einKunde)) {
			throw new AccountExistiertBereitsException(einKunde,
					" - in 'einfuegen()'");
		}

		accountBestand.add(einKunde);
	}
	
	/**
	 * Methode zum Einf¸gen eines Mitarbeiter-Accounts
	 * 
	 * @param einMitarbeiter
	 * @throws AccountExistiertBereitsException
	 */
	
	// Mitarbeiter einfuegen
	public void MitarbeiterEinfuegen(Mitarbeiter einMitarbeiter)
			throws AccountExistiertBereitsException {
		if (accountBestand.contains(einMitarbeiter)) {
			throw new AccountExistiertBereitsException(einMitarbeiter,
					" - in 'einfuegen()'");
		}

		accountBestand.add(einMitarbeiter);
	}

	/**
	 * Methode um Account einzuloggen
	 * 
	 * @param name
	 * @param passwort
	 * @return user
	 * @throws AccountExistiertNichtException
	 */

	public Account loginAccount(String name, String passwort)
			throws AccountExistiertNichtException {

		for (Account user : accountBestand) {
			if (user.getName().equals(name)
					&& user.getPasswort().equals(passwort)) {
				return user;
			}
		}

		throw new AccountExistiertNichtException(name, passwort);
	}
	
	/**
	 * Methode um Account auszuloggen
	 * 
	 * @param name
	 * @param passwort
	 * @return user
	 * 
	 */
	
	public Account logoutAccount(String name, String passwort){
		for (Account user : accountBestand) {
			if (user.getName().equals(name)
					&& user.getPasswort().equals(passwort)) {
				user = null;
				return user;
			}
		}
		return null;
	}

	/**
	 * Methode zum Schreiben der Kundendaten in eine Datei.
	 * 
	 * @param datei Datei, die Accounts enth‰lt
	 * @throws IOException
	 */

	public void schreibeKundendaten(String datei) throws IOException {
		// PersistenzManager für Schreibvorgänge oeffnen
		pm.openForWriting(datei);

		Iterator<Account> iter = accountBestand.iterator();
		while (iter.hasNext()) {
			Account person = iter.next();
			if (person instanceof Kunde)
				pm.speichereKunde((Kunde) person);
		}

		// Persistenz-Schnittstelle wieder schlieﬂen
		pm.close();
	}
	
	/**
	 * Methode zum Schreiben der Mitarbeiterdaten in eine Datei.
	 * 
	 * @param datei Datei, die Accounts enth‰lt
	 * @throws IOException
	 */

	public void schreibeMitarbeiterdaten(String datei) throws IOException {
		// PersistenzManager fuer Schreibvorgänge öˆffnen
		pm.openForWriting(datei);

		Iterator<Account> iter = accountBestand.iterator();
		while (iter.hasNext()) {
			Account person = iter.next();
			if (person instanceof Mitarbeiter)
				pm.speichereMitarbeiter((Mitarbeiter) person);
		}

		// Persistenz-Schnittstelle wieder schlieﬂen
		pm.close();

	}
	
	// Getter und Setter
	
	/**
	 * Methode zum Abrufen des Accountbestands
	 * 
	 * @return accountbestand Accountbestand
	 */
	
	public List<Account> getAccountBestand() {
		return accountBestand;
	}
	
	/**
	 * Methode zum Abrufen des LoginStatus (Mitarbeiter oder Kunde)
	 * 
	 * @return loginStatus
	 */
	
	public boolean getLoginStatus() {
		return loginStatus;
	}

}