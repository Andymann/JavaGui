package view;

public class ViewFactory {
	public static final String VIEWNAME_TEST1 = "Test1";
	public static final String VIEWNAME_TEST2 = "Test2";

	private ViewInterface[] arrViews;
	private static ViewFactory instance = null;
	private Gui gui;
	
	public static ViewFactory getInstance() {
		if (instance==null) {
			instance = new ViewFactory();
		}
		return instance;
	}
	
	private ViewFactory() {
		
	}
	
	
	/**
	 * Alle Screen vorbereiten
	 */
	public void initGui(){
		gui = new Gui();
		arrViews =new ViewInterface[]{
			
			new View_Test1(ViewFactory.VIEWNAME_TEST1),
			new View_Test2(ViewFactory.VIEWNAME_TEST2),
			
		};
		
		for(int i=0; i<arrViews.length; i++){
			gui.addView(arrViews[i]);
		}
		gui.finishGui();		
		//gui.selectView(ViewNames.VIEW_STARTUP_INFO);
	
	}

	
	public void selectView(String pViewName) {
		this.gui.selectView(pViewName);
	}
}//Class
