//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package overideClasses;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class simpleFrame extends JFrame implements Runnable {
	public simpleFrame(int weight,int height,String title){
		super(title);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenwidth = (int)screenSize.getWidth();
		int screenheight = (int)screenSize.getHeight();
		setPreferredSize(new Dimension(weight,height));
		setLocation(new Point(screenwidth/2-getPreferredSize().width/2,screenheight/2-(int)(getPreferredSize().height/1.9)));
//		applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setIconImage(new ImageIcon(this.getClass().getResource("/images/icon.png")).getImage());
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setSize(weight, height);
	}
	public void addComponent(Component contents){
		revalidate();
		repaint();
		add(contents,BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	@Override
	public void run() {
		setVisible(true);
	}
}
