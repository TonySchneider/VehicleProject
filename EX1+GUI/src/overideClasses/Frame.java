//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package overideClasses;
import generalFrame.Contents;
import generalFrame.testDriveFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


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
			Component contents = new Contents().createComponents();
			addComponent(contents);
		}
	public void addComponent(Component contents){
		revalidate();
		repaint();
		add(contents);
		revalidate();
		repaint();
	}
    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
        	if (testDriveFrame.listIsEmpty()){
				int result = JOptionPane.showConfirmDialog(null, "Do you sure you want to exit?", null, JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION)
					super.processWindowEvent(e); 
        	}
        	else
        		JOptionPane.showMessageDialog(null, "You can not exit because there is a car on the test drive.");
       }
    }
	@Override
	public void run() {
		setVisible(true);
	}
	
}
