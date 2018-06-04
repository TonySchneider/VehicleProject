//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package overideClasses;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Frame extends JFrame implements Runnable {
		private BackGroundPanel background;
		public Frame(){
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = (int)screenSize.getWidth();
			int height = (int)screenSize.getHeight();
			setLocationRelativeTo(null);  
			setLayout(null);
			setIconImage(new ImageIcon(this.getClass().getResource("/images/icon.png")).getImage());
	    	background = new BackGroundPanel(new BorderLayout(),"/images/background.png");
			setContentPane(background);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setPreferredSize(new Dimension(1000,700));
			setLocation(new Point(width/2-getPreferredSize().width/2,height/2-(int)(getPreferredSize().height/1.9)));
			pack();
		}
	public void addComponent(Component contents){
		revalidate();
		repaint();
		add(contents);
		revalidate();
		repaint();
	}
	@Override
	public void run() {
		setVisible(true);
	}
	
}
