//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package generalFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import overideClasses.Frame;


public class generalFrame {
	private static Frame frame = new Frame();
	private static Thread generalThread = new Thread(frame);
	public static void main(String[] args) {
		generalThread.start();
	}
	public static void setAddCarLocation(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		frame.setLocation(new Point(width-frame.getWidth(),frame.getY()));
	}
	public static void setDefaultLocation(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		frame.setLocation(new Point(width/2-frame.getPreferredSize().width/2,height/2-(int)(frame.getPreferredSize().height/1.9)));
	}
	public static void unEnable(){
		frame.setEnabled(false);
		}
	public static void Enable(){
		frame.setEnabled(true);
	}
}