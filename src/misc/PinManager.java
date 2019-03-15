package misc;

import controller.ControllerImpl;
import model.ObserverData;

public class PinManager {

	public static final int PIN_LENGTH = 4;
	private static PinManager instance = null;
	private String sPIN ="";
	
	public static PinManager getInstance() {
		if(instance==null) {
			instance = new PinManager();
		}
		return instance;
	}
	
	private PinManager() {
		
	}
	
	
	public void addDigit(char pDigit) {		
		if(sPIN.length()<PIN_LENGTH) {
			this.sPIN += pDigit;
		}
		String sTMP="";
		for(int i=0; i<sPIN.length(); i++) {
			sTMP += "*";
		}
		//System.out.println("PinManager.addDigit(): '" + pDigit + "'. Gesamt:" + sPIN);
		ControllerImpl.getInstance().makeNotify(ObserverData.ODTYPE_PIN, -1, sTMP, false);
	}
	
	public void resetPIN() {
		this.sPIN = "";
		ControllerImpl.getInstance().makeNotify(ObserverData.ODTYPE_PIN, -1, "", false);
	}
	
	public String getPIN() {
		return this.sPIN;
	}
	
	/**
	 * Wurden genug Ziffern fuer eine komplette PIN eingegeben?
	 * @return
	 */
	public boolean isPinComplete() {
		return this.sPIN.length()==PIN_LENGTH;
	}
}
