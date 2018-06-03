<<<<<<< HEAD
package generalFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import overideClasses.simpleFrame;

public class changeFlagFrame extends simpleFrame{

	public changeFlagFrame(int x,int y,int weight,int height,String title) {
		super(x,y,weight,height,title);
		setAlwaysOnTop(true);
		JRadioButton[] options = new JRadioButton[7];
		options[0] = new JRadioButton("Israel");
        options[0].setActionCommand("Israel");
        options[1] = new JRadioButton("U.S.A");
        options[1].setActionCommand("U.S.A");
        options[2] = new JRadioButton("Germany");
        options[2].setActionCommand("Germany");
        options[3] = new JRadioButton("Italy");
        options[3].setActionCommand("Italy");
        options[4] = new JRadioButton("Grecia");
        options[4].setActionCommand("Grecia");
        options[5] = new JRadioButton("Somalia");
        options[5].setActionCommand("Somalia");
        options[6] = new JRadioButton("Pirate");
        options[6].setActionCommand("Pirate");
        
        ButtonGroup group = new ButtonGroup();
//        JPanel chooseFlagPane = new JPanel(new BoxLayout(parent, height));
        options[0].setFont(new Font("Arial", Font.BOLD, 12));
        group.add(options[0]);
        group.add(options[0]);
//    	chooseFlagPane.add(options[0]);
        options[0].setSelected(true);
	}

=======
//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package generalFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import Vehicles.Vehicle;
import overideClasses.simpleFrame;
import overideClasses.Panel;

public class changeFlagFrame extends simpleFrame {
	private List<Vehicle> vehicles;
	private List<JToggleButton> flags;
	private static ButtonGroup group = new ButtonGroup();
	private static JTextField selectedField;
	public changeFlagFrame(int x,int y,int weight,int height,String title){
		super(x,y,weight,height,title);
		Panel pane = new Panel();
		JLabel header = new JLabel();
		header.setText("Choose flag to change: ");
		header.setBounds(new Rectangle(new Point(20,10),new Dimension(250,30)));
		header.setFont(new Font("Arial", Font.BOLD, 20));
		flags = new ArrayList<JToggleButton>();
		vehicles = Contents.getList();
		JPanel flagsPanel = new JPanel(new GridLayout(2,4));
		setImages();
		for(int i=0;i<flags.size();i++){
			group.add(flags.get(i));
			flagsPanel.add(flags.get(i));
		}
		flagsPanel.setBounds(new Rectangle(new Point(50,50),flagsPanel.getPreferredSize()));
		JLabel selected = new JLabel();
		selected.setText("Selected vehicle : ");
		selected.setBounds(new Rectangle(new Point(30,350),new Dimension(200,30)));
		selected.setFont(new Font("Arial", Font.BOLD, 20));
		selectedField = new JTextField();
		selectedField.setBounds(new Rectangle(new Point(200,345),new Dimension(200,40)));
		selectedField.setFont(new Font("Arial", Font.BOLD, 20));
		selectedField.setEditable(false);
		JButton submit = new JButton("Submit");
		submit.setFont(new Font("Arial", Font.BOLD, 20));
		submit.setBounds(new Rectangle(new Point(270,410),new Dimension(120,40)));
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!selectedField.getText().equals("")){
					Contents.changeFlag(selectedField.getText());
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "You need choose one of Flags images!");
			}
		});
		pane.add(submit);
		pane.add(header);
		pane.add(selectedField);
		pane.add(selected);
		pane.add(flagsPanel);
		add(pane);
	}
	public void setImages(){
		String [] Flags = { "german","greece","israel","italy","pirates","somalia","usa"};
		
		for(int i=0;i<Flags.length;i++){
			JToggleButton flagImage = new JToggleButton();
			ImageIcon image = new ImageIcon(changeFlagFrame.class.getResource("/images/flages/"+Flags[i]+".png"));
			Image scaledImage = image.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT);
			image = new ImageIcon(scaledImage, image.getDescription());
			flagImage.setIcon(image);
			flagImage.setOpaque(false);
			flagImage.setToolTipText(Flags[i]);
			flagImage.setBorder(BorderFactory.createEmptyBorder());
			flagImage.setContentAreaFilled(false);
			ImageIcon relimage = new ImageIcon(changeFlagFrame.class.getResource("/images/flages/"+Flags[i]+"2.png"));
			Image relscaledImage = relimage.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT);
			relimage = new ImageIcon(relscaledImage, relimage.getDescription());
			flagImage.setRolloverIcon(relimage);
			flags.add(flagImage);
			flagImage.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					selectedField.setText(flagImage.getToolTipText());
				}
			});
		}
	}
>>>>>>> refs/remotes/origin/Tony
}
