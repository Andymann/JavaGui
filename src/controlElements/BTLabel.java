package controlElements;

import java.awt.Insets;

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
}