//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package generalFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import Vehicles.Vehicle;
import overideClasses.simpleFrame;
import overideClasses.Panel;

public class testDriveFrame extends simpleFrame implements ActionListener{
	private static List<Vehicle> vehiclesInDrive = new ArrayList<Vehicle>();
	private int KM  = 0;
	private Panel pane;
	private JLabel label;
	private JTextField field;
	private JButton submit;
	private Task task;
	private Vehicle vehicle;
	private JProgressBar prog;
	private int progress = 0;
	  class Task extends SwingWorker<Void, Void> {
		    @Override
		    public Void doInBackground() {
		      Random random = new Random();
		      setProgress(0);
		      try {
		        Thread.sleep(KM*100);
		        while (progress < 100 && !isCancelled()) {
		          Thread.sleep(random.nextInt(KM*100));
		          progress += random.nextInt(10);
		          prog.setValue(progress);
		          setProgress(Math.min(progress, 100));
		        }
		      } catch (InterruptedException e) {
		      }
		      return null;
		    }

		    @Override
		    public void done() {
		    	Contents.addKM(vehicle, Integer.parseInt(field.getText()));
		    	vehiclesInDrive.remove(vehicle);
		    	Toolkit.getDefaultToolkit().beep();
		    	submit.setEnabled(true);
		    	progress = 0;
		    	prog.setValue(0);
		    	dispose();
		    }
		  }
	public testDriveFrame(int weight,int height,String title,Vehicle vehicle){
		super(weight,height,title);
//		synchronized(this){}
		this.vehicle = vehicle;
		pane = new Panel();
		prog = new JProgressBar(0,100);
		label = new JLabel();
		label.setText("Enter the KM: ");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(new Rectangle(new Point(0,30),label.getPreferredSize()));
		field = new JTextField();
		field.setBounds(new Rectangle(new Point(145,25),new Dimension(130,33)));
		submit = new JButton("Submit");
		submit.setBounds(new Rectangle(new Point(100,70),new Dimension(100,30)));
		submit.setActionCommand("submit");
		submit.addActionListener(this);
		pane.add(label);
		pane.add(submit);
		pane.add(field);
		add(pane);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		vehiclesInDrive.add(vehicle);
		label.setBounds(new Rectangle(new Point(0,10),label.getPreferredSize()));
		field.setBounds(new Rectangle(new Point(145,5),new Dimension(130,33)));
		prog.setBounds(new Rectangle(new Point(35,45),new Dimension(220,20)));
		prog.setValue(progress);
		pane.add(prog);
		KM = Integer.parseInt(field.getText());
		task = new Task();
	    task.execute();
	    submit.setEnabled(false);
	}
	public static List<Vehicle> getListVehiclesInDrive(){return vehiclesInDrive;}
	public static boolean listIsEmpty(){
		if(vehiclesInDrive.size() == 0)
			return true;
		return false;
	}
    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			int result = JOptionPane.showConfirmDialog(null, "Do you sure you want to exit?", null, JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION){
				vehiclesInDrive.remove(vehicle);
		    	Toolkit.getDefaultToolkit().beep();
		    	submit.setEnabled(true);
		    	progress = 0;
		    	prog.setValue(0);
				super.processWindowEvent(e); 
			}
       }
    }
}
