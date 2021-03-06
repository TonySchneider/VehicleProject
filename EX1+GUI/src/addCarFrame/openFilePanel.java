//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package addCarFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import overideClasses.Panel;

public class openFilePanel extends Panel {
    private JButton openImage;
    private JFileChooser file;
    private JTextField field;
    private static File selectedFile;
	public openFilePanel(){
		selectedFile = null;
		file = new JFileChooser();
		field = new JTextField();
		field.setBounds(new Rectangle(new Point(50,40),new Dimension(140,40)));
		field.setEditable(false);
		openImage = new JButton("open file");
		openImage.setBounds(new Rectangle(new Point(70,10),openImage.getPreferredSize()));
		openImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            int returnVal = file.showOpenDialog(openFilePanel.this);
	            if (returnVal == JFileChooser.APPROVE_OPTION)
	            	selectedFile = file.getSelectedFile();
	            field.setText(selectedFile.getAbsolutePath());
			}});
		add(field);
		add(openImage);
	}
	public static boolean opened(){
		if(selectedFile != null) return true;
		else return false;
	}
	public static String getFilePath(){
		System.out.println(selectedFile.getAbsolutePath());
		return selectedFile.getAbsolutePath();}
}
