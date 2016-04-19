package valueobjects;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * Klasse zur Repräsentation der Rechnung.
 */

public class Rechnung {

	// Attribute zur Beschreibung einer Rechnung

	private Kunde kunde = null;
	private Date datum = null;
	private HashMap<Artikel, Integer> positionen = null;
	private float gesamtpreis = 0.0f;

	/**
	 * Konstruktor
	 * 
	 * @param kunde
	 *            Kunde
	 */

	@SuppressWarnings("unchecked")
	public Rechnung(Kunde kunde) {
		this.kunde = kunde;

		// Rechnungsdatum erstellen
		Calendar cal = Calendar.getInstance();
		this.datum = cal.getTime();
		this.positionen = kunde.getWarenkorb().getInhalt();

		this.berechneGesamtpreis();
	}

	/**
	 * Methode zum Berechnen des Gesamtpreises
	 * 
	 */

	private void berechneGesamtpreis() {
		// 1. Schritt: Artikel extrahieren
		Set<Artikel> articles = this.positionen.keySet();

		// 2. Schritt: Siehe Schmierzettel
		for (Artikel artikel : articles) {
			int anzahl = this.positionen.get(artikel);

			this.gesamtpreis = this.gesamtpreis + (anzahl * artikel.getPreis());
		}
	}

	// Getter und Setter

	/**
	 * Methode zum Abrufen des Kunden
	 * 
	 * @return kunde Kunde
	 */
	public Kunde getKunde() {
		return kunde;
	}

	/**
	 * Methode zum Setzen des Kunden
	 * 
	 * @param kunde
	 *            Kunde
	 */
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	/**
	 * Methode zum Abrufen des Datums
	 * 
	 * @return datum Datum
	 */
	public Date getDatum() {
		return datum;
	}

	/**
	 * Methode zum Setzen des Datums
	 * 
	 * @param datum
	 *            Datum
	 */

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	/**
	 * Methode zum Abrufen der Positionen
	 * 
	 * @return positionen
	 */

	public HashMap<Artikel, Integer> getPositionen() {
		return positionen;
	}

	/**
	 * Methode zum Setzen der Positionen
	 * 
	 * @param positionen
	 */
	public void setPositionen(HashMap<Artikel, Integer> positionen) {
		this.positionen = positionen;
	}

	/**
	 * Methode zum Abrufen des Gesamtpreises
	 * 
	 * @return gesamtpreis Gesamtpreis
	 */

	public float getGesamtpreis() {
		return gesamtpreis;
	}

	/**
	 * Methode zum Setzen des Gesamtpreises
	 * 
	 * @param gesamtpreis
	 *            Gesamtpreis
	 */

	public void setGesamtpreis(float gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}
}