package domain;
import valueobjects.Rechnung;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * Klasse zur Verwaltung der Rechnungen
 * 
 */

public class Rechnungsverwaltung {

	// Verwaltung des Rechnungbestands als Liste
	// Als Implementierung der Liste dient ein Vektor
	
	private List<Rechnung> rechnungsBestand = new Vector<Rechnung>();
	
	
	public Rechnungsverwaltung (){
		
	}
	
	/**
	 * Methode zum Einfuegen der Rechnung
	 * 
	 * @param rechnung
	 */
	
	public void fuegeRechnungEin(Rechnung rechnung){
		rechnungsBestand.add(rechnung);
	}	
}