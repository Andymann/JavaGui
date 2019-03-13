package view;

import java.awt.Color;

public interface ViewInterface {

	
	/**
	 * Beschreibt die View eindeutig
	 * @return
	 */
	public String getViewID();
	
	/**
	 * Der ViewName ist technisch, das Label eher fachlich
	 * @return
	 */
	public String getViewLabel();

	/**
	 * Gibt zurueck, ob die View aktiv ausaehlbar ist.
	 * @return
	 */
	public boolean isSelectable();
	
	
	
	/**
	 * Hintergrundfarbe
	 * @return
	 */
	public Color getColor();
	
	/**
	 * Das Passwort fuer die View. Oder NULL
	 * @return
	 */
	public String getPassword();
}
