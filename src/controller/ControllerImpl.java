package controller;

import java.util.ArrayList;
import java.util.Observer;

import model.Model;
import model.ObserverData;
import view.ViewFactory;
import view.ViewInterface;

public class ControllerImpl {

	private static ControllerImpl instance = null;
	private Model model;
	
	private ControllerImpl() {
		this.model = new Model();
	}
	
	public static ControllerImpl getInstance() {
		if(instance==null){
			instance = new ControllerImpl();
		}
		return instance;
	}
	
	public void init() {	
		//new Gui().setVisible( true );
		ViewFactory.getInstance().initGui();
	}
	
	public String getVersion() {
		return model.getVersion();
	}
	
	public String getName() {
		return model.getName();
	}
	
	public void addObserver(Observer pObserver) {
		this.model.addObserver(pObserver);		
	}
	
	public void makeNotify(int pObserverType, int pValue, String pText, boolean pBool) {
		this.model.makeNotify(pObserverType, pValue, pText, pBool);
	}
	
	/**
	 * Aufruf einer View. 
	 * Wenn eine View mit Passwort versehen ist, kann das Password anschliessend mit ControllerImpl.enterViewPIN_Digit(char)
	 * konstruiert werden.
	 * @param pViewID
	 */
	public void selectView(String pViewID) {
		if(!ViewFactory.getInstance().getActiveView().getViewID().equals(pViewID)) {
			ViewFactory.getInstance().selectView(pViewID);
			ViewFactory.getInstance().clearPIN();
			this.model.makeNotify(ObserverData.ODTYPE_VIEWSELECTED, ObserverData.OPVALUE_UNDEFINED, pViewID, false);
		}
	}
	
	/**
	 * Eingabe einer einzelnen Ziffer zur weiteren Konstruktion der kompletten PIN.
	 */
	public void enterViewPIN_Digit(char pDigit) {
		ViewFactory.getInstance().enterPIN_Digit( pDigit );
	}
	
	/**
	 * Das komplette(!) Passwort fuer die in ViewFactory auf Freischaltung wartende View.
	 * @param pPassword
	 */
	@Deprecated
	public void enterViewPIN(String pPassword) {
		ViewFactory.getInstance().enterPIN(pPassword);
	}
	
	/**
	 * Abbruch der Passworteingabe fuer die wartende View.
	 */
	public void cancelViewPIN() {
		ViewFactory.getInstance().cancelPIN();
	}
	
	public void clearViewPIN() {
		ViewFactory.getInstance().clearPIN();
	}
	
	/**
	 * Im Vorfeld wurde eine PIN konstruiert. Hiermit wird der Versuch gestartet, mit der PIN die View
	 * freizuschalten.
	 */
	public void okayViewPIN() {
		ViewFactory.getInstance().okayPIN();
	}
	
	public ArrayList<ViewInterface>getViews(){
		return ViewFactory.getInstance().getViews();
	}
}//Class

