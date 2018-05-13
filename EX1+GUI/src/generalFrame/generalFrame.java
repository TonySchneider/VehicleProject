package generalFrame;

import java.awt.Component;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import overideClasses.Frame;
import Vehicles.Vehicle;


public class generalFrame {
	private static Frame frame;
	public static void main(String[] args) {
		frame = new Frame();
		Component contents = new Contents().createComponents();
		frame.addComponent(contents);
	}
	public static void unVisible(){
		frame.setVisible(false);
	}
}
