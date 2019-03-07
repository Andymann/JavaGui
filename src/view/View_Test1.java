package view;

public class View_Test1 implements ViewInterface{

	private String sViewName;
	
	public View_Test1(String pViewName) {
		this.sViewName = pViewName;
	}
	
	@Override
	public String getViewName() {
		return this.sViewName;
	}

}
