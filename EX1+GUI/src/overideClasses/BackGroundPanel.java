package overideClasses;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackGroundPanel extends JPanel {
	public String imageFile;
	public BackGroundPanel(LayoutManager l,String imageFile) {
		super.setLayout(l);
		this.imageFile = imageFile;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon(this.getClass().getResource(imageFile)).getImage();
		int X = 0;
		int Y = 0;
		int width = getSize().width;
		int height = getSize().height;

		g.drawImage(image, X, Y, width, height, null);
	}

}
