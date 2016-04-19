package domain;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import persistence.FilePersistenceManager;
import persistence.PersistenceManager;

import valueobjects.Artikel;
import domain.exceptions.ArtikelExistiertBereitsException;
import domain.exceptions.ArtikelExistiertNichtException;
import domain.exceptions.BestandUeberschrittenException;

/**
 * Klasse zur Verwaltung von Artikeln.
 *
 * 
 */

public class Artikelverwaltung {

	// Verwaltung des Artikelbestands als Liste
	// Als Implementierung der Liste dient ein Vektor

	private List<Artikel> artikelBestand = new Vector<Artikel>();

	
	// Persistenz-Schnittstelle, die fuer die Details des Dateizugriffs
	// verantwortlich ist
	
	private PersistenceManager pm = new FilePersistenceManager();

	public Artikelverwaltung() {
		
	}

	/**
	 * Methode zum Einlesen von Artikeldaten aus einer Datei.
	 * 
	 * @param datei Datei, die einzulesenden Artikelbestand enthaelt
	 * @throws IOException
	 */

	public void liesDaten(String datei) throws IOException {
		// PersistenzManager fuer Lesevorgaenge oeffnen
		pm.openForReading(datei);

		Artikel einArtikel;
		do {
			// Artikel-Objekt einlesen
			einArtikel = pm.ladeArtikel();

			if (einArtikel != null) {
				// Artikel in Liste einf¸gen
				try {
					einfuegen(einArtikel);
				} catch (ArtikelExistiertBereitsException e1) {
					//
					// Kann hier eigentlich nicht auftreten,
					// daher auch keine Fehlerbehandlung...
					//
				}
			}
		} while (einArtikel != null);

		// Persistenz-Schnittstelle wieder schliessen
		pm.close();
	}
	
	/**
	 * Methode zum Schreiben der Artikeldaten in eine Datei.
	 * 
	 * @param datei Datei, in die der Artikelbestand geschrieben werden soll
	 * @throws IOException
	 */

	public void schreibeArtikel(String datei) throws IOException {

	}

	/**
	 * Methode, die einen Artikel an das Ende der Artikeliste einfuegt.
	 * 
	 * @param einArtikel der einzufuegende Artikel
	 * @throws ArtikelExistiertBereitsException wenn der Artikel bereits existiert
	 */

	public void einfuegen(Artikel einArtikel)
			throws ArtikelExistiertBereitsException {

		// Vergleich der Artikelnummern aller vorhandenen Artikel mit der Nummer
		// des neu anzulegenden Artikels (testArtikel <-> einArtikel)

		for (Artikel testArtikel : artikelBestand) {
			if (testArtikel.getNummer() == einArtikel.getNummer()) {
				throw new ArtikelExistiertBereitsException(/* einArtikel */);
			}
		}

		artikelBestand.add(einArtikel);
	}

	/**
	 * Methode die einen Artikel entfernt
	 * 
	 * @param gesuchteNummer die eingegebene Artikelnummer
	 * @return 
	 */

	public boolean entfernen(int gesuchteNummer) {

		for (Artikel testArtikel : artikelBestand) {
			if (testArtikel.getNummer() == gesuchteNummer) {
				artikelBestand.remove(testArtikel);
				return true;
			}
		}
		return false;
	}

	/**
	 * Methode, um den Bestand eines bereits existierenden Artikels zu ‰ndern.
	 * 
	 * @param gesuchteNummer eingegebene Artikelnummer
	 * @param neuerBestand ge‰nderter Bestand
	 * @return
	 */

	public int aendereBestand(int gesuchteNummer, int neuerBestand)
	throws ArtikelExistiertNichtException {

for (Artikel testArtikel : artikelBestand) {
	if (testArtikel.getNummer() == gesuchteNummer) {
		testArtikel.setBestand(neuerBestand);
		return testArtikel.getBestand();
	}
}
	
		throw new ArtikelExistiertNichtException(gesuchteNummer);

}

	/**
	 * Methode, die anhand eines Titels nach Artikeln sucht. Es wird eine Liste
	 * von Artikeln zurueckgegeben, welche mit dem exakten Titel uebereinstimmt.
	 * 
	 * @param artname Titel des gesuchten Artikels
	 * @return Liste der Artikel mit gesuchtem Titel (evtl. leer)
	 * 
	 */

	// VERSUCH GESCHEITERT
	public List<Artikel> sucheArtikel(String artname) {
		// auch fuer das Suchergebnis bietet sich 
		// die Verwendung von Generics an
		List<Artikel> suchErg = new Vector<Artikel>();
				
		Iterator<Artikel> iter = artikelBestand.iterator();
		while (iter.hasNext()) {
			// WICHTIG: Type Cast auf 'Artikel' f¸r sp‰teren Zugriff auf Bezeichnung
			// 		    hier nicht erforderlich wegen Verwendung von Generics
			// 			(-> Vergleiche mit Einsatz von Vector OHNE Generics)
			Artikel art = iter.next();
			if (art.getName().equals(artname))
				suchErg.add(art);
				
		}
		return suchErg;
	}

	/**
	 * Methode, die den Artikelbestand als Vector zurueckgibt.
	 * 
	 * @return Liste aller Artikel im Artikelbestand
	 */
	public List<Artikel> getArtikelBestand() {
		return artikelBestand;
	}
	
	// nach Artikelnamen sortieren
	public List<Artikel> getSortierteArtikelnamen() {
		Collections.sort(artikelBestand, new Comparator<Artikel>() {
			public int compare(Artikel a1, Artikel a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		return artikelBestand;
	}

	
	// nach Artikelnummer sortieren
	public List<Artikel> getSortierteArtikelnummern() {
		Collections.sort(artikelBestand, new Comparator<Artikel>() {
			public int compare(Artikel a1, Artikel a2) {
				return a1.getNummer() - a2.getNummer();
			}
		});
		return artikelBestand;
	}

	/**
	 * Methode zum Suchen der Artikel
	 * 
	 * @param gesuchteNummer
	 * @return
	 * @throws ArtikelExistiertNichtException
	 */

	public Artikel artikelSuchen(int gesuchteNummer)
			throws ArtikelExistiertNichtException {
		for (Artikel testArtikel : artikelBestand) {
			if (testArtikel.getNummer() == gesuchteNummer) {
				return testArtikel;
			}
		}

		throw new ArtikelExistiertNichtException(gesuchteNummer);

	}

	/**
	 * Methode zum Schreiben der Artikeldaten
	 * 
	 * @param datei Datei, in die der Artikelbestand geschrieben werden soll
	 * @throws IOException
	 */
	
	public void schreibeDaten(String datei) throws IOException {
		// PersistenzManager für Schreibvorgänge oeffnen
		pm.openForWriting(datei);

		Iterator<Artikel> iter = artikelBestand.iterator();
		while (iter.hasNext()) {
			Artikel a = iter.next();
			pm.speichereArtikel(a);
		}

		// Persistenz-Schnittstelle wieder schlieﬂen
		pm.close();
	}
}