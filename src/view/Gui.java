package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controlElements.BTButton;
import controller.ControllerImpl;
import model.ObserverData;

public class Gui extends JFrame implements Observer{

	
	private JPanel cardLayout;
	private CardLayout cl;
	
	public Gui() {
		
		this.initFrame();
		this.placeCompponents();
		ControllerImpl.getInstance().addObserver( this );
	}
	
	private void initFrame() {
		this.setTitle( ControllerImpl.getInstance().getName() + " Version " + ControllerImpl.getInstance().getVersion() );
		this.getContentPane().setBackground( Color.DARK_GRAY );
		this.setSize( new Dimension(800, 480) );
		this.setLocationRelativeTo( null );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.cardLayout = new JPanel( new CardLayout());
		//this.setUndecorated(true);
	}
	
	
	/**
	 * Hinzufuegen von Views. Anschliessend muss finishGui() aufgerufen werden
	 * @param pFrame
	 * @param pViewname
	 */
	public void addView(ViewInterface pFrame){
		this.cardLayout.add( ((JFrame)pFrame).getContentPane(), (pFrame.getViewName() ));	
	}
	
	public void finishGui(){		
		cl = (CardLayout)(this.cardLayout.getLayout());
		this.setVisible(true);
	}
	
	/**
	 * Ruft einen der im CardLayout hinterlegten Screens auf.
	 * 
	 */
	public void selectView(String pScreenName){
		
		/*
		//----Javax.Swing.Timer findet immer im EDT statt.
		javax.swing.Timer timer = new javax.swing.Timer(0, new ActionListener() {    		
            public void actionPerformed(ActionEvent e) {
            	cl.show(cardLayout, pScreenName);
            }
        });
    	timer.setInitialDelay(0);
        timer.setRepeats(false);
        timer.start();
        */
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	cl.show(cardLayout, pScreenName);
	        }
	    });		
	}
	
	
	private void placeCompponents() {
		this.setLayout( new BorderLayout() );
		this.add( this.cardLayout, BorderLayout.CENTER );
		//this.add( ghf.getContentPane(), BorderLayout.NORTH );
		//this.add( new GuiBottomFrame(WIDTH).getContentPane(), BorderLayout.SOUTH );
		
		
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
