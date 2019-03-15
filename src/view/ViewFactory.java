package view;

import java.util.ArrayList;

import misc.PinManager;

public class ViewFactory {
	public static final String VIEWID_TEST1 = "Test1";
	public static final String VIEWID_TEST2 = "Test2";
	public static final String VIEWID_TEST3 = "Test3";
	public static final String VIEWID_PASSWORD = "PASSWORD";
	
	private ArrayList<ViewInterface> lstView;
	private static ViewFactory instance = null;
	private Gui gui;
	private ViewInterface viWaitingForPassword = null;
	private ViewInterface viActive = null;
	
	
	public static ViewFactory getInstance() {
		if (instance==null) {
			instance = new ViewFactory();
		}
		return instance;
	}
	
	private ViewFactory() {
		this.lstView = new ArrayList<ViewInterface>();
	}
	
	
	/**
	 * Alle Screens vorbereiten
	 */
	public void initGui(){
		gui = new Gui();
		this.lstView.add( new View_Intro("INTRO", "Intro", false, null) );
		this.lstView.add( new View_Password(ViewFactory.VIEWID_PASSWORD, "PaSsWoRd", false, null));
		this.lstView.add( new View_Test1(ViewFactory.VIEWID_TEST1) );
		this.lstView.add( new View_Test2(ViewFactory.VIEWID_TEST2) );
		this.lstView.add( new View_Test3(ViewFactory.VIEWID_TEST3, "View mit PW", true, "1111") );
		
		for(int i=0; i<lstView.size(); i++){
			gui.addView(lstView.get(i));
		}
		gui.finishGui();		
		this.selectView("INTRO");
		//this.selectView_FirstSelectable();	
	}

	/**
	 * Aufruf der ersten auswaehlbaren View.
	 */
	@SuppressWarnings("unused")
	private void selectView_FirstSelectable() {
		for(int i=0; i<this.lstView.size(); i++) {
			if(lstView.get(i).isSelectable()) {
				this.selectView( lstView.get(i).getViewID() );
				break;
			}
		}
	}
	
	/**
	 * Aufruf einer View.
	 * @param pViewID
	 */
	public void selectView(String pViewID) {
		if(this.getViewByID(pViewID).getPassword()==null) {
			this.viWaitingForPassword = null;
			
			//----Caching der aktiven View. Auch fuer Cancel bei Password
			this.viActive=this.getViewByID(pViewID);
			this.gui.selectView(pViewID);
		}else {
			//----Caching der View, die auf Passwortfreigabe wartet.
			this.viWaitingForPassword = this.getViewByID(pViewID);
			this.gui.selectView(ViewFactory.VIEWID_PASSWORD);
			System.out.println("ViewFactory.selectView(): View '" + pViewID +"' hat ein gesetztes Passwort.");
		}
	}
	
	/**
	 * Gibt die aktiv ausgesuhte View zurueck. Wenn eine View auf Freischaltung per PIN wartet, ist die viorherige View solange noch 
	 * die aktive View;
	 * @return
	 */
	public ViewInterface getACitveView() {
		return this.viActive;
	}
	
	/**
	 * Beschreibt die Uebergabe der kompletten(!) PIN.
	 * Wenn mittels selectView() eine View mit Passwort aufgerufen wurde,
	 * kann die View hiermit freigeschaltet werden.	
	 * @param pPassword
	 */
	@Deprecated
	public void enterPIN(String pPassword) {
		if(this.viWaitingForPassword!=null) {
			if(pPassword.equals(this.viWaitingForPassword.getPassword())) {
				this.gui.selectView( this.viWaitingForPassword.getViewID() );
				
				//----Pass by Value?
				this.viActive = this.viWaitingForPassword;
				this.viWaitingForPassword = null;
				//System.out.println("ViewFactory.enterPassword():" + viActive.getViewID());
			}else {
				//System.out.println("ViewFactory.enterPassword(): Falches Passwort");
				this.gui.selectView( this.viActive.getViewID() );
				this.viWaitingForPassword = null;
			}
		}else {
			System.out.println("ViewFactory.enterPassword(): Keine View zur Freischaltung gecached.");
		}
	}
	
	public void enterPIN_Digit(char pDigit) {
		PinManager.getInstance().addDigit(pDigit);
	}
	
	/**
	 * Abbruch der Passworteingabe fuer die wartende View.
	 */	
	public void cancelPIN() {
		System.out.println("ViewFactory.cancelPassword(): Cancel PIN");
		PinManager.getInstance().resetPIN();
		this.gui.selectView( this.viActive.getViewID() );
		this.viWaitingForPassword = null;
	}
	
	public void clearPIN() {
		PinManager.getInstance().resetPIN();
	}
	
	/**
	 * Im Vorfeld wurde eine PIN konstruiert. Hiermit wird der Versuch gestartet, mit der PIN die View
	 * freizuschalten.
	 */
	public void okayPIN() {
		if(PinManager.getInstance().isPinComplete() ) {
			if(this.viWaitingForPassword.getPassword().contentEquals( PinManager.getInstance().getPIN())) {
				
				this.gui.selectView( this.viWaitingForPassword.getViewID() );
				this.viActive = this.viWaitingForPassword;
				this.viWaitingForPassword = null;
				//System.out.println("ViewFactory.enterPassword():" + viActive.getViewID());
			}else {
				//System.out.println("ViewFactory.enterPassword(): Falches Passwort");
				//this.gui.selectView( this.viActive.getViewID() );
			}
			PinManager.getInstance().resetPIN();
		}
	}
	
	
	public ArrayList<ViewInterface>getViews(){
		return this.lstView;
	}
	
	private ViewInterface getViewByID(String pViewID) {
		ViewInterface vi = null;
		for(int i=0; i<this.lstView.size(); i++) {
			if(lstView.get(i).getViewID().equals(pViewID)) {
				vi=lstView.get(i);
				break;
			}
		}
		return vi;
	}
	
}//Class
