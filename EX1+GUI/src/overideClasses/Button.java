//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package overideClasses;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Button extends JButton {
	public Button(String image,String rolloverImage){
		setIcon(new ImageIcon(this.getClass().getResource(image)));
		setRolloverIcon(new ImageIcon(this.getClass().getResource(rolloverImage)));
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
	}
}
