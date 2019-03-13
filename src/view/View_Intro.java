package view;

import java.awt.Color;

import javax.swing.JFrame;

public class View_Intro extends JFrame implements ViewInterface{

	private String sViewID;
	private String sViewLabel;
	private boolean bIsSelectable;
	//private JButton btnTest;	
	private Color col = Color.WHITE.darker();
	private String sPassword;
	
	public View_Intro(String pViewID) {
		this.initView(pViewID, null, true, null);
	}
	
	public View_Intro(String pViewID, String pViewLabel, boolean pIsSelectable, String pPassword) {
		this.initView(pViewID, pViewLabel, pIsSelectable, pPassword);
	}
	
	private void initView(String pViewID, String pViewLabel, boolean pIsSelectable, String pPassword) {
		this.sViewID = pViewID;
		this.sPassword = pPassword;
		new ViewHelper().initRaster(15, 9, this, false);		
		this.initButtons();
		this.placeComponents();
		this.getContentPane().setBackground( col );
		this.sViewLabel = pViewLabel;
		this.bIsSelectable = pIsSelectable;
	}
	
	private void initButtons() {
		//this.btnTest = new BTButton("btnTest");
	}
	
	private void placeComponents() {
		//new ViewHelper().placeComponent(this, btnTest, 1, 1, 2, 1);
	}
	
	
	@Override
	public String getViewID() {
		return this.sViewID;
	}

	@Override
	public boolean isSelectable() {
		return bIsSelectable;
	}

	@Override
	public Color getColor() {
		return col;
	}

	@Override
	public String getViewLabel() {
		return this.sViewLabel;
	}

	@Override
	public String getPassword() {
		return sPassword;
	}

}//Class
