package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import controlElements.BTButton;
import controlElements.BTLabel;
import controller.ControllerImpl;
import model.ObserverData;

public class View_Password extends JFrame implements ViewInterface, Observer{

	private String sViewID;
	private String sViewLabel;
	private boolean bIsSelectable;
	private JButton btnPW_Correct;	
	private JButton btnPW_Incorrect;	
	private JButton btnPW_Cancel;	
	private Color col = Color.CYAN.darker().darker().darker();
	private String sPassword;
	
	private JButton btn_0;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton btn_OK;
	private JButton btn_Cancel;
	private JButton btn_Clear;
	
	private JLabel lblPIN;
	
	
	public View_Password(String pViewID) {
		this.initView(pViewID, null, true, null);
	}
	
	public View_Password(String pViewID, String pViewLabel, boolean pIsSelectable, String pPassword) {
		this.initView(pViewID, pViewLabel, pIsSelectable, pPassword);
	}
	
	private void initView(String pViewID, String pViewLabel, boolean pIsSelectable, String pPassword) {
		this.sViewID = pViewID;
		this.sPassword = pPassword;
		new ViewHelper().initRaster(16, 9, this, false);		
		this.initButtons();
		this.initLabels();
		this.placeComponents();
		this.getContentPane().setBackground( col );
		this.sViewLabel = pViewLabel;
		this.bIsSelectable = pIsSelectable;
		
		ControllerImpl.getInstance().addObserver( this );
	}
	
	private void initLabels() {		
		this.lblPIN = new BTLabel();
		this.lblPIN.setOpaque(true);
		this.lblPIN.setBackground(Color.PINK);
		this.lblPIN.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.lblPIN.setText("");
	}
	
	private void initButtons() {
		this.btnPW_Correct = new BTButton("PW Correct");
		this.btnPW_Correct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN("1111");
		    }		    
		});
		
		this.btnPW_Incorrect = new BTButton("PW Incorrect");
		this.btnPW_Incorrect.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN("2222");
		    }		    
		});
		
		this.btnPW_Cancel = new BTButton("Cancel");
		this.btnPW_Cancel.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().cancelViewPIN();
		    }		    
		});
		
		
		
		btn_0 = new BTButton("0");
		btn_1 = new BTButton("1");
		btn_2 = new BTButton("2");
		btn_3 = new BTButton("3");
		btn_4 = new BTButton("4");
		btn_5 = new BTButton("5");
		btn_6 = new BTButton("6");
		btn_7 = new BTButton("7");
		btn_8 = new BTButton("8");
		btn_9 = new BTButton("9");
		btn_OK = new BTButton("OK");
		btn_Cancel = new BTButton("Cancel");
		btn_Clear = new BTButton("Clear");
		
		
		
		btn_0.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN_Digit('0');
		    }		    
		});
		
		btn_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN_Digit('1');
		    }		    
		});
		
		btn_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN_Digit('2');
		    }		    
		});
		
		btn_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN_Digit('3');
		    }		    
		});
		
		btn_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN_Digit('4');
		    }		    
		});
		
		btn_5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN_Digit('5');
		    }		    
		});
		
		btn_6.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN_Digit('6');
		    }		    
		});
		
		btn_7.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN_Digit('7');
		    }		    
		});
		
		btn_8.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN_Digit('8');
		    }		    
		});
		
		btn_9.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().enterViewPIN_Digit('9');
		    }		    
		});
		
		
		
		btn_Cancel.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().cancelViewPIN();
		    }		    
		});
		
		btn_Clear.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().clearViewPIN();
		    }		    
		});
		
		btn_OK.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	ControllerImpl.getInstance().okayViewPIN();
		    }		    
		});
		
		
	}
	
	private void placeComponents() {
//		new ViewHelper().placeComponent(this, btnPW_Correct, 1, 1, 2, 1);
//		new ViewHelper().placeComponent(this, btnPW_Incorrect, 3, 1, 2, 1);
//		new ViewHelper().placeComponent(this, btnPW_Cancel, 9, 1, 2, 1);
		
		new ViewHelper().placeComponent(this, lblPIN, 5, 1, 6, 1);
		new ViewHelper().placeComponent(this, btn_1, 5, 2, 2, 1);
		new ViewHelper().placeComponent(this, btn_2, 7, 2, 2, 1);
		new ViewHelper().placeComponent(this, btn_3, 9, 2, 2, 1);
		
		new ViewHelper().placeComponent(this, btn_4, 5, 3, 2, 1);
		new ViewHelper().placeComponent(this, btn_5, 7, 3, 2, 1);
		new ViewHelper().placeComponent(this, btn_6, 9, 3, 2, 1);
		
		new ViewHelper().placeComponent(this, btn_7, 5, 4, 2, 1);
		new ViewHelper().placeComponent(this, btn_8, 7, 4, 2, 1);
		new ViewHelper().placeComponent(this, btn_9, 9, 4, 2, 1);
		
		new ViewHelper().placeComponent(this, btn_0, 7, 5, 2, 1);
		
		new ViewHelper().placeComponent(this, btn_Cancel, 4, 6, 2, 1);
		new ViewHelper().placeComponent(this, btn_OK, 10, 6, 2, 2);
		
		new ViewHelper().placeComponent(this, btn_Clear, 4, 7, 2, 1);
		
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

	@Override
	public void update(Observable arg0, Object arg1) {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	try {
	        		ObserverData obsData = (ObserverData)arg1;
	        		if(obsData.getType()==ObserverData.ODTYPE_PIN) {
	        			//System.out.println("View_Password.update() Received ObserverData.Type_Test:" + obsData.getText());
	        			View_Password.this.lblPIN.setText( obsData.getText() );
	        		}
	        	}catch(Exception e) {
	        		System.out.println("View_Password.update() Exception:" + e.getMessage() );
	        	}
	        }
	    });		
		
	}

}//Class
