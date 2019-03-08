package controller;

import java.util.Observer;

import model.Model;
import view.Gui;
import view.ViewFactory;

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
	
	public void selectView(String pViewName) {
		ViewFactory.getInstance().selectView(pViewName);
	}
	
	
}//Class

