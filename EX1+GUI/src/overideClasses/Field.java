package overideClasses;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Field extends JPanel {

	private JTextField field;
	public Field(int x, int y){
		setLayout(new FlowLayout());

		field = new JTextField();
		field.setPreferredSize(new Dimension(100,30));
//		field.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setBounds(new Rectangle(new Point(x, y),new Dimension(240,50)));
		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		add(field);
		setOpaque(false);
	}
	public void setText(String text){

		field.setText(text);
		field.setEditable(false);
	}
	public void setRed(){
		field.setEditable(true);
		field.setText("");

	}
	public String getFieldText(){return field.getText();}
}
