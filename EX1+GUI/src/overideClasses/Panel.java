package overideClasses;

import java.awt.ComponentOrientation;

import javax.swing.JPanel;


public class Panel extends JPanel {
	public Panel(){
		
		applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setLayout(null);
		setOpaque(false);
	}
}
