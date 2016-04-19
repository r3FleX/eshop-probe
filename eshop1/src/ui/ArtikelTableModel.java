package ui;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import valueobjects.Artikel;
import valueobjects.Kunde;
import valueobjects.Warenkorb;



public class ArtikelTableModel extends DefaultTableModel {
	
	Kunde kunde;
	private HashMap<Artikel, Integer> positionen = null;
	private float gesamtpreis = 0.0f;
	private int anzahl = 0;
	
	/**
	 * Konstruktor
	 * 
	 * @param articles
	 * @param columnNames
	 */
	
	public ArtikelTableModel(List<Artikel> articles, Vector columnNames) {
		// Ober-Objekt der Klasse DefaultTableModel initialisieren
		super();
	
		// Spaltennamen in geerbtem Attribut merken
		this.columnIdentifiers = columnNames;
		
		// Bücher-Liste aufbereiten
		setDataVector(articles);
	}
	
	
	/**
	 * Tabellendaten hinzufügen
	 * 
	 * @param articles
	 */
	
	
	public void setDataVector(List<Artikel> articles) {
		// Bücher aus Liste aufbereiten:
		// DefaultTableModel erwartet Repräsentation der Tabellendaten
		// als Vector von Vectoren
		Vector rows = new Vector();
		for (Artikel artikel: articles) {
			Vector einArtikelAlsVector = new Vector();
			einArtikelAlsVector.add(artikel.getNummer());
			einArtikelAlsVector.add(artikel.getName());
			einArtikelAlsVector.add(artikel.getBestand());
			einArtikelAlsVector.add(artikel.getPreis());
			einArtikelAlsVector.add(artikel.getPackungsgroesse());

			if(artikel.getPackungsgroesse() > 0) {
				einArtikelAlsVector.add("x");
			}

			rows.add(einArtikelAlsVector);

		}
		// Vector von Vectoren mit Buecher-Strings eintragen
		// (geerbte Methode)
		this.setDataVector(rows, columnIdentifiers);
	}
	
	/**
	 * Tabellendaten hinzufügen (für den Warenkorb)
	 * 
	 * @param articles
	 */
	
	public void setDataVector2(Warenkorb warenkorb) {
		Set<Artikel> articles = warenkorb.getInhalt().keySet();
		
//		this.positionen = kunde.getWarenkorb().getInhalt();
//		Set<Artikel> articles1 = this.positionen.keySet();
		
		// Bücher aus Liste aufbereiten:
		// DefaultTableModel erwartet Repräsentation der Tabellendaten
		// als Vector von Vectoren
//		Set<Artikel> articles1 = this.positionen.keySet();
		Vector rows = new Vector();
		for (Artikel artikel : articles) {
//			 for (Artikel artikel1 : articles1) {
//				 anzahl = this.positionen.get(artikel1);
//				 
//			 }
			
//			for (Artikel artikel1 : articles) {
////				int anzahl = kunde.getWarenkorb().getInhalt().get(artikel1);
//				int anzahl = this.positionen.get(artikel);
//			}
			Vector einArtikelAlsVector = new Vector();
			einArtikelAlsVector.add(artikel.getNummer());
			einArtikelAlsVector.add(artikel.getName());
			einArtikelAlsVector.add((Integer)warenkorb.getInhalt().get(artikel));
			einArtikelAlsVector.add(artikel.getPreis());
			
		//	einArtikelAlsVector.add
			rows.add(einArtikelAlsVector);
		}
		// Vector von Vectoren mit Buecher-Strings eintragen
		// (geerbte Methode)
		this.setDataVector(rows, columnIdentifiers);
	}
}
