package overideClasses;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class simpleFrame extends JFrame {
	public simpleFrame(int x,int y,int weight,int height,String title){
		super(title);
		setLocation(x,y);
//		applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setIconImage(new ImageIcon(this.getClass().getResource("/images/icon.png")).getImage());
		pack();
		setSize(weight, height);
	}
	public void addComponent(Component contents){
		revalidate();
		repaint();
		add(contents,BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}
