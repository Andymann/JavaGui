package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import controlElements.BTButton;

public class View_Test2 extends JFrame implements ViewInterface{

	private String sViewName;
	private JButton btnTest;	
	
	
	public View_Test2(String pViewName) {
		this.sViewName = pViewName;
		this.initView();
		this.initButtons();
		this.placeComponents();
	}
	
	private void initView() {
		this.getContentPane().setBackground( Color.BLUE.darker() );
		new ViewHelper().initRaster(15, 9, this, false);		
	}
	
	private void initButtons() {
		this.btnTest = new BTButton("btnTest");
	}
	
	private void placeComponents() {
		new ViewHelper().placeComponent(this, btnTest, 2, 2, 2, 1);
	}
	
	
	@Override
	public String getViewName() {
		return this.sViewName;
	}

}//Class
