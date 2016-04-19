package persistence;

import java.io.IOException;

import valueobjects.Account;
import valueobjects.Artikel;
import valueobjects.Kunde;
import valueobjects.Mitarbeiter;

/**
 *
 * Allgemeine Schnittstelle f�r den Zugriff auf ein Speichermedium
 * (z.B. Datei oder Datenbank) zum Ablegen von beispielsweise
 * Artikel- oder Kundendaten.
 * 
 * Das Interface muss von Klassen implementiert werden, die eine
 * Persistenz-Schnittstelle realisieren wollen.
 * 
 */

public interface PersistenceManager {

	public void openForReading(String datenquelle) throws IOException;
	
	public void openForWriting(String datenquelle) throws IOException;
	
	public boolean close();

	/**
	 * Methode zum Einlesen der Artikeldaten aus einer externen Datenquelle.
	 * 
	 * @return Artikel-Objekt, wenn Einlesen erfolgreich, false null
	 */
	public Artikel ladeArtikel() throws IOException;
	

	/**
	 * Methode zum Schreiben der Artikeldaten in eine externe Datenquelle.
	 * 
	 * @param a Artikel-Objekt, das gespeichert werden soll
	 * @return true, wenn Schreibvorgang erfolgreich, false sonst
	 */
	public boolean speichereArtikel(Artikel a) throws IOException;

	/**
	 * Methode zum Laden eines Kunden
	 * @return
	 * @throws IOException
	 */
	
	public Kunde ladeKunde() throws IOException;

	/**
	 * Methode zum Speichern eines Kunden
	 * @return
	 * @throws IOException
	 */
	public boolean speichereKunde(Kunde k) throws IOException;
	
	/**
	 * Methode zum Laden eines Mitarbeiters
	 * @return
	 * @throws IOException
	 */
	public Mitarbeiter ladeMitarbeiter() throws IOException;
	
	/**
	 * Methode zum Speichern eines Mitarbeiters
	 * @return
	 * @throws IOException
	 */
	public boolean speichereMitarbeiter(Mitarbeiter m) throws IOException;
	
}