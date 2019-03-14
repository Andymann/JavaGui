package controller;

import java.util.ArrayList;
import java.util.Observer;

import misc.PinManager;
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
	 * Wenn eine View mit Passwort versehen ist, kann das Password anschliessend mit ControllerImpl.enterViewPassword(String)
	 * uebergeben werden.
	 * @param pViewID
	 */
	public void selectView(String pViewID) {
		ViewFactory.getInstance().selectView(pViewID);
		this.model.makeNotify(ObserverData.ODTYPE_VIEWSELECTED, ObserverData.OPVALUE_UNDEFINED, pViewID, false);
	}
	
	/**
	 * Eingabe einer einzelnen(!) Ziffer zur weiteren Konsturktion der kompletten PIN.
	 */
	public void enterViewPIN_Digit(char pDigit) {
		PinManager.getInstance().addDigit(pDigit);
	}
	
	/**
	 * Das komplette(!) Passwort fuer die in ViewFactory auf Freischaltung wartende View.
	 * @param pPassword
	 */
	public void enterViewPIN(String pPassword) {
		ViewFactory.getInstance().enterPIN(pPassword);
	}
	
	/**
	 * Abbruch der Passworteingabe fuer die wartende View.
	 */
	public void cancelViewPIN() {
		ViewFactory.getInstance().cancelPIN();
	}
	
	
	public ArrayList<ViewInterface>getViews(){
		return ViewFactory.getInstance().getViews();
	}
}//Class

