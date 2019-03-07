package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controlElements.BTButton;
import controller.ControllerImpl;
import model.ObserverData;

public class Gui extends JFrame implements Observer{

	private JButton btnTest;
	
	public Gui() {
		
		this.initFrame();
		
		new ViewHelper().initRaster(15, 9, this, false);
		this.initButtons();
		this.placeCompponents();
		ControllerImpl.getInstance().addObserver( this );
	}
	
	private void initFrame() {
		this.setTitle( ControllerImpl.getInstance().getName() + " Version " + ControllerImpl.getInstance().getVersion() );
		this.getContentPane().setBackground( Color.DARK_GRAY.brighter() );
		this.setSize( new Dimension(800, 480) );
		this.setLocationRelativeTo( null );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//this.setUndecorated(true);
	}
	
	private void initButtons() {
		this.btnTest = new BTButton("btnTest");
	}
	
	private void placeCompponents() {
		new ViewHelper().placeComponent(this, btnTest, 4, 3, 2, 1);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	try {
	        		ObserverData obsData = (ObserverData)arg1;
	        		if(obsData.getType()==ObserverData.ODTYPE_TEST) {
	        			System.out.println("Gui.update() Received ObserverData.Type_Test:" + obsData.getText());
	        		}else if(obsData.getType()==ObserverData.ODTYPE_VIEW_BG_COLOR) {
	        			Gui.this.getContentPane().setBackground( Color.decode(obsData.getText()) );
	        		}
	        	}catch(Exception e) {
	        		System.out.println("Gui.update() Exception:" + e.getMessage() );
	        	}
	        }
	    });		
	}
	
	
	
	
	
	
	
}//Gui
