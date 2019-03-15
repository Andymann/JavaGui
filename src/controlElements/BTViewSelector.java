package controlElements;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.ControllerImpl;
import model.ObserverData;
import view.ViewInterface;

public class BTViewSelector extends JButton implements Observer{
	
	private String sConnectedViewID;
	boolean bIsSelected;
	
	public BTViewSelector() {
		super();
		this.init();

	}
	
	/**
	 * 
	 * @param pViewID Beschreibt den eindeutigen Viewnamen
	 * @param pText Falls ein Label (ein ansprechender Text) fuer die View existiert
	 */
	public BTViewSelector(ViewInterface pView) {
		
		sConnectedViewID = pView.getViewID();
		
		String sTmp = pView.getViewLabel();
		if(sTmp==null) {
			sTmp= pView.getViewID();
		}
		
		super.setText(sTmp);
		this.init();
		this.setListener(pView.getViewID());
	}
	
	
	private void init() {
		this.setFocusPainted(false);
		this.setPreferredSize(this.getSize());	//dadurch ist die Breite der Buttons unabhaengig vom Text
		this.setMargin(new Insets(1, 1, 1, 1));		
	}
	
	private void setListener(String pViewID) {
		this.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().selectView(pViewID);
		    }		    
		});
	}
	
/*
	 @Override
	   protected void paintComponent(Graphics g) {
	      Graphics2D g2 = (Graphics2D) g.create();
	      Color col;
	      if( this.bIsSelected) {
	    	  col = Color.PINK.darker();
	      }else {
	    	  col= Color.WHITE;
	      }
	      
	      g2.setPaint(new GradientPaint(new Point(0, 0), Color.WHITE, new Point(0, getHeight()), col));
	      //g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
	      g2.setPaint(Color.BLACK);
	      g2.drawString(getText(), 30, 12);
	      g2.dispose();

	      // super.paintComponent(g);
	   }
*/
	@Override
	public void update(Observable arg0, Object arg1) {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	try {
	        		ObserverData obsData = (ObserverData)arg1;
	        		if(obsData.getType()==ObserverData.ODTYPE_VIEWSELECTED) {
	        			if(obsData.getText().contentEquals(sConnectedViewID)) {
	        				System.out.println("BTLayerSelector View Selected:" + obsData.getText());
	        				BTViewSelector.this.bIsSelected=true;
	        			}else {
	        				BTViewSelector.this.bIsSelected = false;
	        			}
	        		}
	        	}catch(Exception e) {
	        		System.out.println("BTLayerSelector(" + BTViewSelector.this.sConnectedViewID + ").update() Exception:" + e.getMessage() );
	        	}
	        }
	    });		
	}

}
