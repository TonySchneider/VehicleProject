package overideClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class undecoratedFrame extends JFrame {
	private static int someOpen = 0;
	public undecoratedFrame(int x,int y,int weight,int height,String title){
		super(title);
		setLocation(x,y);
		applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		setLayout(null);
		setIconImage(new ImageIcon(this.getClass().getResource("/images/icon.png")).getImage());
		setUndecorated(true);
//		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		pack();
		setSize(weight, height);
//		if(someOpen == 0)
//			setVisible(true);
//		someOpen++;
	}
	public void addComponent(Component contents){
		revalidate();
		repaint();
		add(contents,BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	public void setVisible2(){
		if(someOpen == 0)
			setVisible(true);
		someOpen++;
		setAlwaysOnTop(true);
	}
	public void unVisible(){
		someOpen = 0;
		setVisible(false);
	}
}