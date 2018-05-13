package generalFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import overideClasses.simpleFrame;
import overideClasses.Panel;

public class testDriveFrame extends simpleFrame {
	public testDriveFrame(int x,int y,int weight,int height,String title,String name){
		super(x,y,weight,height,title);
		Panel pane = new Panel();
		JLabel label = new JLabel();
		label.setText("Enter the KM: ");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(new Rectangle(new Point(0,30),label.getPreferredSize()));
		JTextField field = new JTextField();
		field.setBounds(new Rectangle(new Point(145,25),new Dimension(130,33)));
		JButton submit = new JButton("Submit");
		submit.setBounds(new Rectangle(new Point(100,70),new Dimension(100,30)));
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Contents.addKM(name, Integer.parseInt(field.getText()));
				dispose();
			}
		});
		pane.add(label);
		pane.add(submit);
		pane.add(field);
//		pane.setBounds(new Rectangle(new Point(0,0),new Dimension(weight,height)));
		add(pane);
	}
}
