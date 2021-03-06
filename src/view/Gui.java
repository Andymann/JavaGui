package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ci.Colors;
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
		this.getContentPane().setBackground( Colors.BG_DEFAULT );
		this.setSize( new Dimension(800, 480) );
		this.setLocationRelativeTo( null );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.cardLayout = new JPanel( new CardLayout());
		//this.setUndecorated(true);
		this.addResizeListener();
	}
	
	private void addResizeListener() {
		this.getRootPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                ControllerImpl.getInstance().resized();
            }
        });
	}
	
	/**
	 * Hinzufuegen von Views. Anschliessend muss finishGui() aufgerufen werden
	 * @param pFrame
	 * @param pViewname
	 */
	public void addView(ViewInterface pFrame){
		this.cardLayout.add( ((JFrame)pFrame).getContentPane(), (pFrame.getViewID() ));	
	}
	
	public void finishGui(){		
		cl = (CardLayout)(this.cardLayout.getLayout());
		BottomFrame bf = new BottomFrame();
		bf.updateFrame();		
		this.add(bf.getContentPane(), BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	/**
	 * Ruft einen der im CardLayout hinterlegten Screens auf.
	 * Findet im EDT statt.
	 * 
	 */
	public void selectView(String pScreenName){
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	cl.show(cardLayout, pScreenName);
	        }
	    });		
	}
	
	
	private void placeCompponents() {
		this.setLayout( new BorderLayout() );
		this.add( this.cardLayout, BorderLayout.CENTER );
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
