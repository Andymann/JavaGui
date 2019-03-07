package view;

public class ViewFactory {
	public static final String VIEWNAME_TEST1 = "Test1";
	public static final String VIEWNAME_TEST2 = "Test2";

	
	private static ViewFactory instance = null;
	
	
	public static ViewFactory getInstacne() {
		if (instance==null) {
			instance = new ViewFactory();
		}
		return instance;
	}
	
	private ViewFactory() {
		
	}
	
}//Class
