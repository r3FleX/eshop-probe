package domain.exceptions;

/**
 * Exception zur Signalisierung, dass der Bestand �berschritten ist (z.B. bei einem
 * Einfuegevorgang).
 */

public class BestandUeberschrittenException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BestandUeberschrittenException() {
		super("Bestand ueberschritten!");
	}
}
