package view;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import ci.Colors;
import controlElements.BTLayerSelector;
import controller.ControllerImpl;

public class BottomFrame extends JFrame {
	
	public BottomFrame() {
		
		this.getContentPane().setBackground( Colors.BG_DEFAULT );
		
		ViewHelper vh = new ViewHelper();
		vh.setInsets(new Insets(01,10,01,10));
		//vh.initRaster(4, 3, this, false, 15);
		
	}
	
	/**
	 * Holt aus ViewHelper die notwendigen Informationen, um die passende Anzahl Buttons 
	 * mit den ensprechenden Eigenschaften bereitzustellen.
	 */
	public void updateFrame() {
		ViewHelper vh = new ViewHelper();
		ArrayList<ViewInterface> lstView = ControllerImpl.getInstance().getViews();
		ArrayList<ViewInterface> lstViewSelectable = new ArrayList<ViewInterface>();
		
		for(int i=0; i<lstView.size(); i++) {
			if(lstView.get(i).isSelectable()) {
				lstViewSelectable.add( lstView.get(i) );
			}
		}
		
		if((lstViewSelectable!=null) && (lstViewSelectable.size()>1)) {
			vh.initRaster(lstViewSelectable.size()*2, 2, this, false, 15);
			//vh.setInsets(new Insets(2,10,2,10));
			
			
			for(int i=0; i<lstViewSelectable.size(); i++) {
				//if(lstView.get(i).isSelectable()) {
					BTLayerSelector btn = new BTLayerSelector(lstViewSelectable.get(i));
					ControllerImpl.getInstance().addObserver(btn);
					vh.placeComponent(this, btn, i*2, 0, 2, 2);
				//}
			}
		}
		//vh.setInsets(new Insets(01,10,01,10));
		
		//vh.initRaster(10, 3, this, true);
		//btn1.setPreferredSize( new Dimension(0,40) );
		//vh.placeComponent(this, btn1, 0, 1, 2, 2);
		//vh.placeComponent(this, btn2, 2, 1, 2, 2);
	}
}//Class
