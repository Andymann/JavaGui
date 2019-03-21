package controlElements;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class BTLabel extends JLabel {

	public BTLabel() {
		super();
		this.init();
	}
	
	public BTLabel(String pText) {
		super(pText);
		this.init();
	}
	
	private void init() {
		this.setPreferredSize(this.getSize());	//dadurch ist die Breite der Buttons unabhaengig vom Text				
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    final Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
	    g2d.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    super.paintComponent(g2d);
	}
}