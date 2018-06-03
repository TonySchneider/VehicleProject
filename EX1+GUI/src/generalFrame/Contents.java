//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package generalFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import overideClasses.Button;
import overideClasses.Panel;
import addCarFrame.addCarFrame;
import Vehicles.SeaVehicle;
import Vehicles.Vehicle;

public class Contents {
	private static List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private static List<JToggleButton> images = new ArrayList<JToggleButton>();
	private static int count = -1;
	private static Panel pane;
	private static Panel viewCars;
	private static ButtonGroup group = new ButtonGroup();
	private static JTextField selectedField;
	public Component createComponents(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		pane = new Panel();
		JLabel copyright = new JLabel("copyright");
		copyright.setText("Powered by TonySchneider(205515828) & DanielSuhrayev(205583008)");
		copyright.setForeground(Color.white);
		copyright.setBounds(new Rectangle(new Point(950,735), copyright.getPreferredSize()));
//		setLocation(new Point(width/2-getPreferredSize().width/2,height/2-(int)(getPreferredSize().height/1.9)));
		Button addCar = new Button("/images/addCarButton.png","/images/addCarButton2.png");
		addCar.setBounds(new Rectangle(new Point(7,20),addCar.getPreferredSize()));
		addCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addCarFrame addCarFrame = new addCarFrame(600,700,"add new car");
			}
		});
		Button resetCars = new Button("/images/resetCars.png","/images/resetCars2.png");
		resetCars.setBounds(new Rectangle(new Point(15,150),resetCars.getPreferredSize()));
		resetCars.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the KM for all vehicles?", null, JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION){
					for(int i=0;i<vehicles.size();i++){
						vehicles.get(i).setZero();
						images.get(i).setToolTipText(vehicles.get(i).toString());
					}
				}
			}
		});
		Button changeFlag = new Button("/images/changeFlag.png","/images/changeFlag2.png");
		changeFlag.setBounds(new Rectangle(new Point(15,250),changeFlag.getPreferredSize()));
		changeFlag.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeFlagFrame cfFrame = new changeFlagFrame(700,500,"Change flags");
//				if(vehicles.size() > 0)
					cfFrame.setVisible(true);
//				else
//					JOptionPane.showMessageDialog(null, "There are no cars in stock.");
			}
		});
//		JLabel background2 = new JLabel();
//		background2.setIcon(new ImageIcon(this.getClass().getResource("/images/background2.png")));
//		background2.setBounds(new Rectangle(new Point(480,30),background2.getPreferredSize()));
		viewCars = new Panel();
		viewCars.setLayout(new GridLayout(4,4,0,0));
		viewCars.setBounds(new Rectangle(new Point(260,10),new Dimension(740,520)));
		Button buyCar = new Button("/images/buy.png","/images/buy2.png");
		buyCar.setBounds(new Rectangle(new Point(260,575),buyCar.getPreferredSize()));
		buyCar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!selectedField.getText().equals("")){
					removeImage(selectedField.getText());
				}
				else
					JOptionPane.showMessageDialog(null, "You need choose one of vehicles!");
				selectedField.setText("");
			}});
		Button testDrive = new Button("/images/testDrive.png","/images/testDrive2.png");
		testDrive.setBounds(new Rectangle(new Point(400,575),testDrive.getPreferredSize()));
		testDrive.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				testDriveFrame tdFrame = new testDriveFrame(300,150,"Test Drive",selectedField.getText());
				if(!selectedField.getText().equals("")){
					tdFrame.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "You need choose one of vehicles!");
				selectedField.setText("");
			}
		});
		JLabel selected = new JLabel();
		selected.setText("Selected vehicle : ");
		selected.setBounds(new Rectangle(new Point(250,545),new Dimension(200,30)));
		selected.setFont(new Font("Arial", Font.BOLD, 20));
		selectedField = new JTextField();
		selectedField.setBounds(new Rectangle(new Point(680,660),new Dimension(200,40)));
		selectedField.setFont(new Font("Arial", Font.BOLD, 20));
		selectedField.setEditable(false);
		pane.add(selectedField);
		pane.add(selected);
		pane.add(testDrive);
		pane.add(buyCar);
		pane.add(viewCars);
		pane.add(copyright);
//		pane.add(background2);
		pane.add(resetCars);
		pane.add(changeFlag);
		pane.add(addCar);
		return pane;
	}
	public static void addVehicle(Vehicle vehicle){
		count++;
		vehicles.add(vehicle);
	}
	public static List<Vehicle> getList(){return vehicles;}
	public static void addImage(){
		JToggleButton imageVehicle = new JToggleButton();
		ImageIcon image;
		if(vehicles.get(count).getImage() != null)
			image = new ImageIcon(Contents.class.getResource("/images/vehicles/"+vehicles.get(count).getImage()));
		else
			image = new ImageIcon(vehicles.get(count).getImagePath());
		Image scaledImage = image.getImage().getScaledInstance(140, 120, Image.SCALE_DEFAULT);
		image = new ImageIcon(scaledImage, image.getDescription());
		imageVehicle.setActionCommand(vehicles.get(count).getName());
		imageVehicle.setIcon(image);
		imageVehicle.setOpaque(false);
		imageVehicle.setToolTipText(vehicles.get(count).toString());
		imageVehicle.setBorder(BorderFactory.createEmptyBorder());
		imageVehicle.setContentAreaFilled(false);
		imageVehicle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedField.setText(group.getSelection().getActionCommand());
			}
		});
		images.add(imageVehicle);
		group.add(imageVehicle);
		viewCars.add(imageVehicle);
		refreshPane();
	}
	public static void removeImage(String name){
		for(int i=0;i<images.size();i++)
			if(vehicles.get(i).getName().equals(name)){
				count--;
				vehicles.remove(i);
				images.remove(i);
			}
		viewCars.removeAll();
		for(int i=0;i<images.size();i++){
			viewCars.add(images.get(i));
		}
		refreshPane();
	}
	public static void refreshPane(){
		viewCars.setVisible(false);
		viewCars.setVisible(true);
	}
	public static void addKM(String name,int km){
		for(int i=0;i<vehicles.size();i++)
			if(vehicles.get(i).getName().equals(name)){
				vehicles.get(i).addKM(km);
				images.get(i).setToolTipText(vehicles.get(i).toString());
			}
		refreshPane();
	}
	public static void changeFlag(String flag){
		for(int i=0;i<vehicles.size();i++)
			if(vehicles.get(i) instanceof SeaVehicle){
				((SeaVehicle)vehicles.get(i)).set_country_flag(flag);
				images.get(i).setToolTipText(vehicles.get(i).toString());
			}
	}
}
