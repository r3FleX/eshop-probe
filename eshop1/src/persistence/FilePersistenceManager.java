package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import valueobjects.Artikel;
import valueobjects.Kunde;
import valueobjects.Massengutartikel;
import valueobjects.Mitarbeiter;


/**
 * Realisierung einer Schnittstelle zur persistenten Speicherung von
 * Daten in Dateien.
 * 
 * @see shop.persistence.PersistenceManager
 * 
 */

public class FilePersistenceManager implements PersistenceManager {

	private BufferedReader reader = null;
	private PrintWriter writer = null;
	
	
	public void openForReading(String datei) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(datei));
	}

	public void openForWriting(String datei) throws IOException {
		writer = new PrintWriter(new BufferedWriter(new FileWriter(datei)));
	}

	public boolean close() {
		if (writer != null)
			writer.close();
		
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return false;
			}
		}

		return true;
	}

	
	/**
	 * 
	 * Methode zum Einlesen der Artikeldaten aus einer externen Datenquelle.
	 * 
	 * @return Artikel
	 */
	public Artikel ladeArtikel() throws IOException {
		String zeile = null;
		
		// 1. Zeile: Artikelname
		String artname = liesDaten();
		if (artname == null) {
			// keine Daten mehr vorhanden
			return null;   
		}
		zeile = this.liesDaten();
		if (zeile == null) {
			return null;
		}

		// 2. Zeile: Artikel-Nr.
		int artikelNummer = Integer.parseInt(zeile);

		// 3. Zeile: Bestand
		zeile = liesDaten();
		if (zeile == null) {
			return null;
		}
		
		int bestand = Integer.parseInt(zeile);

		// 4. Zeile: Preis
		zeile = liesDaten();
		if (zeile == null) {
			return null;
		}
		
		float preis = Float.parseFloat(zeile);

		// 5. Zeile: Packungsgroesse
		zeile = liesDaten();
		if (zeile == null) {
			return null;
		}
	
		int packung = Integer.parseInt(zeile);
		boolean massengut;
		
		if(packung > 0) {
			massengut = true;
		}
		else {
			massengut = false;
		}
		
		// neues Artikel-Objekt anlegen und zurückgeben
		
		if (!massengut) {
			return new Artikel(artname, artikelNummer, bestand, preis);
		}
		else {
			return new Massengutartikel(artname, artikelNummer, bestand, preis, packung);
		}
	}
	
	/**
	 * Methode zum Speichern eines Artikels
	 * 
	 * @param a Artikel-Objekt, das gespeichert werden soll
	 * @return true, wenn Schreibvorgang erfolgreich, sonst false
	 */
	
	public boolean speichereArtikel(Artikel a) throws IOException {
		this.schreibeDaten(a.getName());
		this.schreibeDaten(new Integer(a.getNummer()).toString());
		this.schreibeDaten(new Integer(a.getBestand()).toString());
		this.schreibeDaten(new Float(a.getPreis()).toString());
		this.schreibeDaten(new Integer(a.getPackungsgroesse()).toString());
		
		return true;
	}
	

	/**
	 * 
	 * Methode zum Einlesen der Kundendaten aus einer externen Datenquelle.
	 * 
	 * @return Kunde
	 */

	public Kunde ladeKunde() throws IOException {
		// Name einlesen
		String name = liesDaten();
		if (name == null) {
			// keine Daten mehr vorhanden
			return null;
		}
		// Rest einlesen ...
		String passwort = liesDaten();
		
		String nummer = liesDaten();
		int nummer1 = Integer.parseInt(nummer);
		
		String strasse = liesDaten();
		
		String postleitzahl = liesDaten();
		int plz = Integer.parseInt(postleitzahl);
		
		String ort = liesDaten();
		
		// neues Kunden-Objekt anlegen und zurückgeben
		return new Kunde(name, passwort, nummer1, strasse, plz, ort);
	}
	
	/**
	 * Methode zum Speichern der Kundendaten
	 * 
	 * @param k Kundenobjekt
	 * @throws IOException
	 */
	
	@Override
	public boolean speichereKunde(Kunde k) throws IOException {
		// Name usw
		schreibeDaten(k.getName());
		schreibeDaten(k.getPasswort());
		schreibeDaten(new Integer(k.getAccountNr()).toString());
		schreibeDaten(k.getStrasse());
		schreibeDaten(new Integer(k.getPlz()).toString());
		schreibeDaten(k.getWohnort());
		
		return true;
	}
	
	/**
	 * Methode zum Einlesen der Kundendaten aus einer externen Datenquelle.
	 * 
	 * return Mitarbeiter
	 * @throws IOException
	 */
	public Mitarbeiter ladeMitarbeiter() throws IOException {
		// Name einlesen
		String name = liesDaten();
		if (name == null) {
			// keine Daten mehr vorhanden
			return null;
		}
		// Rest einlesen ...
		String passwort = liesDaten();
		
		String nummer = liesDaten();
		int nummer1 = Integer.parseInt(nummer);
		
		// neues Mitarbeiter-Objekt anlegen und zurückgeben
		return new Mitarbeiter(name, passwort, nummer1);
	}
	
	/**
	 * Methode zum Speichern der Mitarbeiterdaten
	 * 
	 * @param m Mitarbeiterobjekt
	 * @throws IOException
	 */
	
	@Override
	public boolean speichereMitarbeiter(Mitarbeiter m) throws IOException {
		// Name usw
		schreibeDaten(m.getName());
		schreibeDaten(m.getPasswort());
		schreibeDaten(new Integer(m.getAccountNr()).toString());
		
		return true;
	}
	
	/*
	 * Private Hilfsmethoden
	 */
	
	private String liesDaten() throws IOException {
		if (reader != null)
			return reader.readLine();
		else
			return "";
	}

	private void schreibeDaten(String daten) {
		if (writer != null)
			writer.println(daten);
	}
}