package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewHelper {
	
	public void placeComponent(JFrame pFrame, Component pComponent, int x, int y, int pWidth, int pHeight) {
		GridBagConstraints g = new GridBagConstraints();
		g.insets = new Insets(01, 01, 01, 01);
		g.gridx = x; 
		g.gridy = y;
		g.fill=GridBagConstraints.BOTH;
		g.gridheight = pHeight;
		g.gridwidth = pWidth;		
		pFrame.add(pComponent, g);
		
	}
	
	/**
	 * Spannt ein Raster auf, mit dem es anschliessend einfacher ist, Objekte zu platzieren.
	 * 16:9		Standard Screen
	 * 15:9		Official RPI Touchscreen
	 * @param pX
	 * @param pY
	 * @param pContainer
	 * @param pRasterVisible
	 */
	public void initRaster(int pX, int pY, Container pContainer, boolean pRasterVisible){

		pContainer.setLayout( new GridBagLayout() );
		JLabel[] lblBlanko = new JLabel[pX+pY-1];
		for(int i=0; i<lblBlanko.length; i++){
			lblBlanko[i] = new JLabel("");
			lblBlanko[i].setBackground( Color.GREEN );		
			lblBlanko[i].setOpaque( pRasterVisible );
			lblBlanko[i].setPreferredSize(lblBlanko[i].getSize());
		}

		//Die BlankoLabels platzieren
		GridBagConstraints gbcBlanko = new GridBagConstraints();
		gbcBlanko.insets = new Insets(01, 01, 01, 01);
		gbcBlanko.weightx = 1.0;
		gbcBlanko.weighty = 1.0;

		//----Horizontal
		for(int i=0; i<pX; i++){
			gbcBlanko.gridx=i; 
			gbcBlanko.gridy=0;
			gbcBlanko.fill = GridBagConstraints.BOTH;
			pContainer.add(lblBlanko[i], gbcBlanko);
		}

		//----Vertikal
		for(int i=1; i<pY; i++){
			gbcBlanko.gridx=0;
			gbcBlanko.gridy=i; 
			gbcBlanko.fill = GridBagConstraints.BOTH;
			pContainer.add(lblBlanko[i+pX-1], gbcBlanko);
		}
	}

	
	
}//Class
