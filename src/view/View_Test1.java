package view;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controlElements.BTButton;
import controlElements.BTLabel;
import controlElements.FontResizingLabel;

public class View_Test1 extends JFrame implements ViewInterface{

	private static final int WIDTH = 15;
	private static final int HEIGHT = 9;
	
	
	private String sViewID;
	private String sViewLabel;
	private boolean bIsSelectable;
	private JButton btnTest;	
	private Color col = Color.RED.darker();
	private String sPassword;
	
	private JLabel lblHeadline;
	
	public View_Test1(String pViewID) {
		this.initView(pViewID, null, true, null);
	}
	
	public View_Test1(String pViewID, String pViewLabel, boolean pIsSelectable, String pPassword) {
		this.initView(pViewID, pViewLabel, pIsSelectable, pPassword);
	}
	
	
	
	private void initView(String pViewID, String pViewLabel, boolean pIsSelectable, String pPassword) {
		this.sViewID = pViewID;
		this.sPassword = pPassword;
		new ViewHelper().initRaster(WIDTH, HEIGHT, this, false);
		this.initLabels();
		this.initButtons();
		this.placeComponents();
		this.getContentPane().setBackground( col );
		this.sViewLabel = pViewLabel;
		this.bIsSelectable = pIsSelectable;
	}
	
	
	
	private void initLabels() {
		this.lblHeadline = new BTLabel();
		this.lblHeadline = new FontResizingLabel("asd");
		this.lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		if(this.sViewLabel!=null) {
			this.lblHeadline.setText( sViewLabel);
		}else {
			this.lblHeadline.setText( sViewID );
		}
	}
	
	private void initButtons() {
		this.btnTest = new BTButton("btnTest");
	}
	
	private void placeComponents() {
		new ViewHelper().placeComponent(this, lblHeadline, 0, 0, WIDTH, 1);
		new ViewHelper().placeComponent(this, btnTest, 1, 1, 2, 1);
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
