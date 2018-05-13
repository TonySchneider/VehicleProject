package generalFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import overideClasses.simpleFrame;

public class changeFlagFrame extends simpleFrame{

	public changeFlagFrame(int x,int y,int weight,int height,String title) {
		super(x,y,weight,height,title);
		setAlwaysOnTop(true);
		JRadioButton[] options = new JRadioButton[7];
		options[0] = new JRadioButton("Israel");
        options[0].setActionCommand("Israel");
        options[1] = new JRadioButton("U.S.A");
        options[1].setActionCommand("U.S.A");
        options[2] = new JRadioButton("Germany");
        options[2].setActionCommand("Germany");
        options[3] = new JRadioButton("Italy");
        options[3].setActionCommand("Italy");
        options[4] = new JRadioButton("Grecia");
        options[4].setActionCommand("Grecia");
        options[5] = new JRadioButton("Somalia");
        options[5].setActionCommand("Somalia");
        options[6] = new JRadioButton("Pirate");
        options[6].setActionCommand("Pirate");
        
        ButtonGroup group = new ButtonGroup();
//        JPanel chooseFlagPane = new JPanel(new BoxLayout(parent, height));
        options[0].setFont(new Font("Arial", Font.BOLD, 12));
        group.add(options[0]);
        group.add(options[0]);
//    	chooseFlagPane.add(options[0]);
        options[0].setSelected(true);
	}

}
