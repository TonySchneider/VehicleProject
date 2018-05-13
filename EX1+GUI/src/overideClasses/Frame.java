package overideClasses;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Frame extends JFrame {
		private BackGroundPanel background;
		public Frame(){
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			setMaximumSize(new Dimension(dim.width,dim.height));
			setLayout(null);
			setIconImage(new ImageIcon(this.getClass().getResource("/images/icon.png")).getImage());
	    	background = new BackGroundPanel(new BorderLayout(),"/images/background.png");
			setContentPane(background);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setUndecorated(true);
			pack();
			setExtendedState(JFrame.MAXIMIZED_BOTH); 
//			setSize(screenWidth, screenHeight);
			setVisible(true);
		}
	public void addComponent(Component contents){
		revalidate();
		repaint();
		add(contents);
		revalidate();
		repaint();
	}
}
