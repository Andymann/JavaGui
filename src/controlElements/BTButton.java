package controlElements;

import java.awt.Insets;

import javax.swing.JButton;

public class BTButton extends JButton{
	
	public BTButton() {
		super();
		this.init();
	}
	
	public BTButton(String pText) {
		super( pText );
		this.init();
	}
	
	
	private void init() {
		this.setFocusPainted(false);
		this.setPreferredSize(this.getSize());	//dadurch ist die Breite der Buttons unabhaengig vom Text
		this.setMargin(new Insets(1, 1, 1, 1));
		
	}

}
