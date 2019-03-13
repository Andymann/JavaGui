package view;

import java.util.ArrayList;

public class ViewFactory {
	public static final String VIEWNAME_TEST1 = "Test1";
	public static final String VIEWNAME_TEST2 = "Test2";
	public static final String VIEWNAME_TEST3 = "Test3";

	private ArrayList<ViewInterface> lstView;
	private static ViewFactory instance = null;
	private Gui gui;
	
	
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
		this.lstView.add( new View_Test1(ViewFactory.VIEWNAME_TEST1) );
		this.lstView.add( new View_Test2(ViewFactory.VIEWNAME_TEST2) );
		this.lstView.add( new View_Test3(ViewFactory.VIEWNAME_TEST3, "View mit PW", true, "1111") );
		
		for(int i=0; i<lstView.size(); i++){
			gui.addView(lstView.get(i));
		}
		gui.finishGui();		
		//gui.selectView(ViewNames.VIEW_STARTUP_INFO);	
	}

	
	public void selectView(String pViewID) {
		if(this.getViewByID(pViewID).getPassword()==null) {
			this.gui.selectView(pViewID);
		}else {
			System.out.println("ViewFactory.selectView(): View '" + pViewID +"' hat ein gesetztes Passwort.");
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
