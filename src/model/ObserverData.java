package model;

import java.awt.Color;

public class ObserverData {
	
	public static final int OPVALUE_UNDEFINED = -1;
	public static final String OPTEXT_UNDEFINED = null;
	public static final boolean OPBOOL_UNDEFINED = false;
	
	
	public static final int ODTYPE_TEST = 0x01;
	
	/**
	 * Eine View wurde aufgerufen.
	 * Die ViewID steck in getText()
	 */
	public static final int ODTYPE_VIEWSELECTED = 0x02;
	
	/**
	 * Setzen der Hintergrundfarbe einer View. Der Farbwert kommt per String.
	 */
	public static final int ODTYPE_VIEW_BG_COLOR = 0x10;
	
	/**
	 * Alles, was mit derPIN fuer eine View zu tun hat.
	 */
	public static final int ODTYPE_PIN = 0x11;
	
	
	
	private int iType;
	private int iValue;
	private String sText;
	private boolean bVal;
	
	
	public ObserverData(int pObserverTpe, int pValue, String pText, boolean pBool) {
		this.iType = pObserverTpe;
		this.iValue = pValue;
		this.sText = pText;
		this.bVal = pBool;
	}
	
	public int getType() {
		return this.iType;
	}
	
	public int getValue() {
		return this.iValue;		
	}
	
	public String getText() {
		return this.sText;
	}
	
	public boolean getBool() {		
		return this.bVal;
	}

}
