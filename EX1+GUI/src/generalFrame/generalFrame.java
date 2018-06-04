//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package generalFrame;

import java.awt.Component;
import overideClasses.Frame;


public class generalFrame {
	private static Frame frame;
	public static void main(String[] args) {
		frame = new Frame();
		Component contents = new Contents().createComponents();
		frame.addComponent(contents);
		new Thread(frame).start();
	}
	
}
