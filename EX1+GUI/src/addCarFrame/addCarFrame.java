//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package addCarFrame;

import generalFrame.Contents;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


import overideClasses.BackGroundPanel;
import overideClasses.Button;
import overideClasses.Panel;
import overideClasses.ComboBox;
import overideClasses.Field;
import overideClasses.simpleFrame;
import Vehicles.Amphibious;
import Vehicles.SimpleBicycle;
import Vehicles.Cruise;
import Vehicles.DownGame;
import Vehicles.DownSpyware;
import Vehicles.Frigate;
import Vehicles.Jeep;
public class addCarFrame extends simpleFrame{
	private BackGroundPanel background;
	public addCarFrame(int weight,int height,String title){
		super(weight,height,title);
		setVisible(true);
		setAlwaysOnTop(true);
		background = new BackGroundPanel(new BorderLayout(),"/images/addCarBackground.png");
		setContentPane(background);
		Panel pane = new Panel();
		JPanel chooseCarPane = new JPanel(new FlowLayout());
		chooseCarPane.setOpaque(false);
		JRadioButton[] options = new JRadioButton[9];
        options[0] = new JRadioButton("Jeep");
        options[0].setActionCommand("Jeep");
        options[1] = new JRadioButton("Frigate");
        options[1].setActionCommand("Frigate");
        options[2] = new JRadioButton("DownSpyware");
        options[2].setActionCommand("DownSpyware");
        options[3] = new JRadioButton("DownGame");
        options[3].setActionCommand("DownGame");
        options[4] = new JRadioButton("Amphibious");
        options[4].setActionCommand("Amphibious");
        options[5] = new JRadioButton("SimpleBicycle");
        options[5].setActionCommand("SimpleBicycle");
        options[6] = new JRadioButton("Cruise");
        options[6].setActionCommand("Cruise");
        options[7] = new JRadioButton("ElectricBicycle");
        options[7].setActionCommand("ElectricBicycle");
        options[8] = new JRadioButton("HybridAircraft");
        options[8].setActionCommand("HybridAircraft");
        ButtonGroup group = new ButtonGroup();
        for(int i=0;i<options.length;i++) {
//        	options[i].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            options[i].setFont(new Font("Arial", Font.BOLD, 12));
            options[i].setOpaque(false);
        	group.add(options[i]);
        	chooseCarPane.add(options[i]);
        }
        chooseCarPane.setBounds(new Rectangle(new Point(10,35),chooseCarPane.getPreferredSize()));
        Field[] labels = new Field[8];
        labels[0] = new Field(24,85);//name
        labels[1] = new Field(170,85);//km
        labels[2] = new Field(410,85);//maxpassengers
        labels[3] = new Field(40,132);//maxspeed
        labels[4] = new Field(190,132);//flag
        labels[5] = new Field(50,260);//fualaverage
        labels[6] = new Field(100,218);//engineaverage
        labels[7] = new Field(215,177);;//מקור הכוח
        ComboBox[] comos = new ComboBox[6];
        String[] strs = {"Irrelevant","2","4"};
        comos[0] = new ComboBox(330,218,strs);//wheels
        String[] strs2 = {"Irrelevant","Paved","dirt"};
        comos[1] = new ComboBox(390,132,strs2);//type of road
        String[] strs3 = {"Irrelevant","Army","civil"};
        comos[2] = new ComboBox(-7,177,strs3);//שימוש בכלי
        String[] strs4 = {"Irrelevant","With","Not With"};
        comos[3] = new ComboBox(400,177,strs4);//כיוון השייט
        String[] strs5 = {"Irrelevant","A","B","C"};
        comos[4] = new ComboBox(300,260,strs5);//ניקוד �?נרגטי
        String[] strs6 = {"Irrelevant","MINI","LIMIT","UNLIMIT"};
        comos[5] = new ComboBox(50,300,strs6);//סוג הרישיון
        
		labels[0].setText("");//name
		labels[1].setText("");//km
		labels[2].setText("");//maxpassengers
		labels[3].setText("");//maxspeed
		labels[4].setText("");//flag
		labels[5].setText("");//fualaverage
		labels[6].setText("");//engineaverage
		labels[7].setText("");//מקור הכוח
		comos[0].setLock(0);//wheels
		comos[1].setLock(0);//type of road
		comos[2].setLock(0);//שימוש בכלי
		comos[3].setLock(0);//כיוון השייט
		comos[4].setLock(0);//ניקוד �?נרגטי
		comos[5].setLock(0);//סוג הרישיון
        
		
		options[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				labels[0].setRed();
				labels[1].setText("0");
				labels[2].setText("5");
				labels[3].setRed();
				labels[4].setText("Irrelevant");
				labels[5].setRed();
				labels[6].setRed();
				labels[7].setText("Irrelevant");//מקור הכוח
				comos[0].setLock(2);
				comos[1].setLock(2);
				comos[2].setLock(0);
				comos[3].setLock(0);
				comos[4].setLock(0);
				comos[5].setLock(1);
			}
		});
        options[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				labels[0].setRed();//name
				labels[1].setText("0");//km
				labels[2].setRed();//maxpassengers
				labels[3].setRed();//maxspeed
				labels[4].setText("ISRAEL");//flag
				labels[5].setText("500");//fualaverage
				labels[6].setText("4 YEARS");//engineaverage
				labels[7].setText("Irrelevant");//מקור הכוח
				comos[0].setLock(0);//wheels
				comos[1].setLock(0);//type of road
				comos[2].setLock(0);//שימוש בכלי
				comos[3].setRed();//כיוון השייט
				comos[4].setLock(0);//ניקוד �?נרגטי
				comos[5].setLock(0);//סוג הרישיון
			}
		});
        options[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				labels[0].setRed();//name
				labels[1].setText("0");//km
				labels[2].setText("1");//maxpassengers
				labels[3].setText("50");//maxspeed
				labels[4].setText("Irrelevant");//flag
				labels[5].setText("500");//fualaverage
				labels[6].setText("4 YEARS");//engineaverage
				labels[7].setRed();//מקור הכוח
				comos[0].setLock(0);//wheels
				comos[1].setLock(0);//type of road
				comos[2].setLock(1);//שימוש בכלי
				comos[3].setLock(0);//כיוון השייט
				comos[4].setLock(3);//ניקוד �?נרגטי
				comos[5].setLock(0);//סוג הרישיון
			}
		});
        options[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				labels[0].setRed();//name
				labels[1].setText("0");//km
				labels[2].setText("0");//maxpassengers
				labels[3].setText("10");//maxspeed
				labels[4].setText("Irrelevant");//flag
				labels[5].setText("Irrelevant");//fualaverage
				labels[6].setText("Irrelevant");//engineaverage
				labels[7].setText("Manual");//מקור הכוח
				comos[0].setLock(0);//wheels
				comos[1].setLock(0);//type of road
				comos[2].setLock(1);//שימוש בכלי
				comos[3].setLock(0);//כיוון השייט
				comos[4].setLock(1);//ניקוד �?נרגטי
				comos[5].setLock(0);//
				
			}
		});
        options[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//(labels[0].getFieldText(),Integer.parseInt(labels[3].getFieldText()),Integer.parseInt(labels[2].getFieldText()),Integer.parseInt(comos[0].getComboText()),comos[1].getComboText(),Boolean.parseBoolean(comos[3].getComboText()),labels[4].getFieldText(),Double.parseDouble(labels[5].getFieldText()),Integer.parseInt(labels[6].getFieldText()))
				labels[0].setRed();//name
				labels[1].setText("");//km
				labels[2].setRed();//maxpassengers
				labels[3].setRed();//maxspeed
				labels[4].setRed();//flag
				labels[5].setRed();//fualaverage
				labels[6].setRed();//engineaverage
				labels[7].setText("Irelevent");//מקור הכוח
				comos[0].setRed();//wheels
				comos[1].setLock(1);//type of road
				comos[2].setLock(0);//שימוש בכלי
				comos[3].setRed();//כיוון השייט
				comos[4].setLock(0);//ניקוד �?נרגטי
				comos[5].setLock(0);//סוג הרישיון
			}
		});
        options[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				labels[0].setRed();//name
				labels[1].setText("0");//km
				labels[2].setRed();//maxpassengers
				labels[3].setRed();//maxspeed
				labels[4].setText("Irrelevant");//flag
				labels[5].setText("Irrelevant");//fualaverage
				labels[6].setText("Irrelevant");//engineaverage
				labels[7].setText("manual");//מקור הכוח
				comos[0].setLock(1);//wheels
				comos[1].setRed();//type of road
				comos[2].setLock(0);//שימוש בכלדי
				comos[3].setLock(0);//כיוון השייט
				comos[4].setLock(1);//ניקוד �?נרגטי
				comos[5].setLock(0);//סוג הרישיון
			}
		});
        options[6].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				labels[0].setRed();//name
				labels[1].setText("0");//km
				labels[2].setRed();//maxpassengers
				labels[3].setRed();//maxspeed
				labels[4].setRed();//flag
				labels[5].setRed();//fualaverage
				labels[6].setRed();;//engineaverage
				labels[7].setText("Irrelevant");//מקור הכוח
				comos[0].setLock(0);//wheels
				comos[1].setLock(0);//type of road
				comos[2].setLock(0);//שימוש בכלי
				comos[3].setLock(1);//כיוון השייט
				comos[4].setLock(0);//ניקוד �?נרגטי
				comos[5].setLock(3);//סוג הרישיון
			}
		});
        options[7].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				labels[0].setRed();//name
				labels[1].setText("0");//km
				labels[2].setRed();//maxpassengers
				labels[3].setRed();//maxspeed
				labels[4].setText("Irrelevant");//flag
				labels[5].setText("20");//fualaverage
				labels[6].setRed();//engineaverage
				labels[7].setText("Irrelevant");//מקור הכוח
				comos[0].setLock(1);//wheels
				comos[1].setRed();//type of road
				comos[2].setLock(0);//שימוש בכלדי
				comos[3].setLock(0);//כיוון השייט
				comos[4].setLock(0);//ניקוד �?נרגטי
				comos[5].setLock(0);//סוג הרישיון
			}
		});
        options[8].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				labels[0].setRed();//name
				labels[1].setText("0");//km
				labels[2].setRed();//maxpassengers
				labels[3].setRed();//maxspeed
				labels[4].setRed();//flag
				labels[5].setRed();//fualaverage
				labels[6].setRed();//engineaverage
				labels[7].setText("Irrelevant");//מקור הכוח
				comos[0].setRed();//wheels
				comos[1].setLock(1);//type of road
				comos[2].setLock(1);//שימוש בכלדי
				comos[3].setRed();//כיוון השייט
				comos[4].setLock(0);//ניקוד �?נרגטי
				comos[5].setLock(0);//סוג הרישיון
			}
		});
        
		imagePanel chooseImagePane = new imagePanel();
		chooseImagePane.setBounds(new Rectangle(new Point(0,330),new Dimension(600, 500)));
		pane.add(chooseImagePane);
        for(int i=0;i<labels.length;i++) pane.add(labels[i]);
        for(int i=0;i<comos.length;i++) pane.add(comos[i]);
        Button submit = new Button("/images/addButton.png","/images/addButton2.png");
        submit.setBounds(new Rectangle(new Point(440,590),submit.getPreferredSize()));
        submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String which = group.getSelection().getActionCommand();
				switch(which){
				case "Jeep":
					Jeep newJeep = new Jeep(labels[0].getFieldText(),Integer.parseInt(labels[3].getFieldText()),Double.parseDouble(labels[5].getFieldText()),Integer.parseInt(labels[6].getFieldText()));
					if(openFilePanel.opened())
						newJeep.setImagePath(openFilePanel.getFilePath());
					else
						newJeep.setImage(imagePanel.getSelected());
					Contents.addVehicle(newJeep);
					Contents.addImage();
					break;
				case "Frigate":
					Frigate newFrigate = new Frigate(labels[0].getFieldText(),Integer.parseInt(labels[2].getFieldText()),Integer.parseInt(labels[3].getFieldText()),Boolean.parseBoolean(comos[3].getComboText()),labels[4].getFieldText());
					if(openFilePanel.opened())
						newFrigate.setImagePath(openFilePanel.getFilePath());
					else
						newFrigate.setImage(imagePanel.getSelected());
					Contents.addVehicle(newFrigate);
					Contents.addImage();
					break;
				case "DownSpyware":
					DownSpyware newDownSpyware = new DownSpyware(labels[0].getFieldText(),labels[7].getFieldText());
					if(openFilePanel.opened())
						newDownSpyware.setImagePath(openFilePanel.getFilePath());
					else
						newDownSpyware.setImage(imagePanel.getSelected());
					Contents.addVehicle(newDownSpyware);
					Contents.addImage();
					break;
				case "DownGame":
					DownGame newDownGame = new DownGame(labels[0].getFieldText());
					if(openFilePanel.opened())
						newDownGame.setImagePath(openFilePanel.getFilePath());
					else
						newDownGame.setImage(imagePanel.getSelected());
					Contents.addVehicle(newDownGame);
					Contents.addImage();
					break;
				case "Amphibious":
					Amphibious newAmphibious;
					if(comos[3].getComboText().equals("With"))
						newAmphibious = new Amphibious(labels[0].getFieldText(),Integer.parseInt(labels[2].getFieldText()),Integer.parseInt(labels[3].getFieldText()),Integer.parseInt(comos[0].getComboText()),comos[1].getComboText(),true,labels[4].getFieldText(),Double.parseDouble(labels[5].getFieldText()),Integer.parseInt(labels[6].getFieldText()));
					else
						newAmphibious = new Amphibious(labels[0].getFieldText(),Integer.parseInt(labels[2].getFieldText()),Integer.parseInt(labels[3].getFieldText()),Integer.parseInt(comos[0].getComboText()),comos[1].getComboText(),false,labels[4].getFieldText(),Double.parseDouble(labels[5].getFieldText()),Integer.parseInt(labels[6].getFieldText()));
					if(openFilePanel.opened())
						newAmphibious.setImagePath(openFilePanel.getFilePath());
					else
						newAmphibious.setImage(imagePanel.getSelected());
					Contents.addVehicle(newAmphibious);
					Contents.addImage();
					break;
				case "SimpleBicycle":
					SimpleBicycle newBicycle = new SimpleBicycle(labels[0].getFieldText(),Integer.parseInt(labels[2].getFieldText()),Integer.parseInt(labels[3].getFieldText()),comos[1].getComboText());
					if(openFilePanel.opened())
						newBicycle.setImagePath(openFilePanel.getFilePath());
					else
						newBicycle.setImage(imagePanel.getSelected());
					Contents.addVehicle(newBicycle);
					Contents.addImage();
					break;
				case "Cruise":
					Cruise newCruise = new Cruise(labels[0].getFieldText(),Integer.parseInt(labels[2].getFieldText()),Integer.parseInt(labels[3].getFieldText()),labels[4].getFieldText(),Double.parseDouble(labels[5].getFieldText()),Integer.parseInt(labels[6].getFieldText()));
					if(openFilePanel.opened())
						newCruise.setImagePath(openFilePanel.getFilePath());
					else
						newCruise.setImage(imagePanel.getSelected());
					Contents.addVehicle(newCruise);
					Contents.addImage();
					break;
				default:
					break;
				}
//		        options[4] = new JRadioButton("Amphibious");
//		        options[4].setActionCommand("Amphibious");
//		        options[5] = new JRadioButton("SimpleBicycle");
//		        options[5].setActionCommand("SimpleBicycle");
//		        options[6] = new JRadioButton("Cruise");
//		        options[6].setActionCommand("Cruise");
				dispose();
			}
		});
        pane.add(submit);
        pane.add(chooseCarPane);
        addComponent(pane);
	}
}
