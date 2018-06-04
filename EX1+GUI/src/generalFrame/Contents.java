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
import overideClasses.updateDatabaseAfterAddVehicle;
import overideClasses.updateDatabaseAfterBuy;
import overideClasses.updateDatabaseAfterChangeFlag;
import overideClasses.updateDatabaseAfterReset;
import addCarFrame.addCarFrame;
import addCarFrame.imagePanel;
import addCarFrame.openFilePanel;
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
	public static JLabel noCarsYet;
	public Component createComponents(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		pane = new Panel();
		JLabel catalog = new JLabel();
		catalog.setText("Cars Catalog");
//		catalog.setForeground(Color.white);
		catalog.setFont(new Font("Arial", Font.BOLD, 20));
		catalog.setBounds(new Rectangle(new Point(250,10), catalog.getPreferredSize()));
		JLabel copyright = new JLabel("copyright");
		copyright.setText("Powered by TonySchneider & DanielSuhrayev");
		copyright.setForeground(Color.white);
		copyright.setFont(new Font("Arial", Font.BOLD, 9));
		copyright.setBounds(new Rectangle(new Point(5,645), copyright.getPreferredSize()));
		Button addCar = new Button("/images/addCarButton.png","/images/addCarButton2.png");
		addCar.setBounds(new Rectangle(new Point(7,20),addCar.getPreferredSize()));
		addCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread addCarFrame = new Thread(new addCarFrame(600,700,"add new car"));
				addCarFrame.start();
			}
		});
		Button resetCars = new Button("/images/resetCars.png","/images/resetCars2.png");
		resetCars.setBounds(new Rectangle(new Point(15,150),resetCars.getPreferredSize()));
		resetCars.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the KM for all vehicles?", null, JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION){
					Thread udFrame = new Thread(new updateDatabaseAfterReset());
					udFrame.start();
				}
			}
		});
		Button changeFlag = new Button("/images/changeFlag.png","/images/changeFlag2.png");
		changeFlag.setBounds(new Rectangle(new Point(15,250),changeFlag.getPreferredSize()));
		changeFlag.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread cfFrame = new Thread(new changeFlagFrame(700,500,"Change flags"));
				cfFrame.start();
			}
		});
		noCarsYet = new JLabel();
		noCarsYet.setIcon(new ImageIcon(this.getClass().getResource("/images/nocarsyet.png")));
		noCarsYet.setBounds(new Rectangle(new Point(420,200),noCarsYet.getPreferredSize()));
		viewCars = new Panel();
		viewCars.setLayout(new GridLayout(4,4,0,0));
		viewCars.setBounds(new Rectangle(new Point(260,40),new Dimension(700,500)));
		Button buyCar = new Button("/images/buy.png","/images/buy2.png");
		buyCar.setBounds(new Rectangle(new Point(260,580),buyCar.getPreferredSize()));
		buyCar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!selectedField.getText().equals("")){
					int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy "+selectedField.getText()+" car?", null, JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION){
						Thread udFrame = new Thread(new updateDatabaseAfterBuy(selectedField.getText()));
						udFrame.start();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "You need choose one of vehicles!");
				selectedField.setText("");
			}});
		Button testDrive = new Button("/images/testDrive.png","/images/testDrive2.png");
		testDrive.setBounds(new Rectangle(new Point(400,580),testDrive.getPreferredSize()));
		testDrive.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				testDriveFrame tdFrame = new testDriveFrame(300,150,"Test Drive",selectedField.getText());
				if(!selectedField.getText().equals("")){
					new Thread(tdFrame).start();
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
		selectedField.setBounds(new Rectangle(new Point(430,545),new Dimension(200,30)));
		selectedField.setFont(new Font("Arial", Font.BOLD, 20));
		selectedField.setEditable(false);
		pane.add(selectedField);
		pane.add(selected);
		pane.add(testDrive);
		pane.add(buyCar);
		pane.add(viewCars);
		pane.add(copyright);
		pane.add(resetCars);
		pane.add(changeFlag);
		pane.add(addCar);
		pane.add(catalog);
		pane.add(noCarsYet);
		return pane;
	}
	public static void addVehicle(Vehicle vehicle){
		count++;
		pane.remove(noCarsYet);
		Thread udV = new Thread(new updateDatabaseAfterAddVehicle(vehicle));
		udV.start();
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
		if(count == -1){
			pane.add(noCarsYet);
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
		Thread udF = new Thread(new updateDatabaseAfterChangeFlag(flag));
		udF.start();
	}
	public static List<Vehicle> getVehicles(){return vehicles;}
	public static List<JToggleButton> getImages(){return images;}
}
