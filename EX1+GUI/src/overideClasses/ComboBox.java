package overideClasses;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComboBox extends JPanel {
	private JComboBox combo;
	public ComboBox(int x, int y,String[] strs){
		setLayout(new FlowLayout());
		combo = new JComboBox(strs);
		combo.setPreferredSize(new Dimension(100,30));
//		combo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setBounds(new Rectangle(new Point(x, y),new Dimension(240,50)));
//		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(combo);
		setOpaque(false);
	}
	public void setLock(int index){
		combo.setSelectedIndex(index);
		combo.setEnabled(false);
	}
	public void setRed(){
		combo.setEnabled(true);
	}
	public String getComboText(){
		return String.valueOf(combo.getSelectedItem());
	}
}