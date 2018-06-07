package overideClasses;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import generalFrame.*;
public class updateDatabase extends simpleFrame {
	private JProgressBar prog;
	private int value = 0;
	private JLabel vprog;
	public updateDatabase() {
		super(300,150,"Updating");
		Panel pane = new Panel();
		JLabel label = new JLabel();
		label.setText("Updating database… Please wait");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(new Rectangle(new Point(10,10),label.getPreferredSize()));
		vprog = new JLabel();
		vprog.setText("Complete - "+String.valueOf(value)+"%");
		vprog.setFont(new Font("Arial", Font.BOLD, 12));
		vprog.setBounds(new Rectangle(new Point(40,35),new Dimension(100,30)));
		prog = new JProgressBar(0,100);
		prog.setBounds(new Rectangle(new Point(40,60),new Dimension(220,30)));
		prog.setValue(value);
		pane.add(label);
		pane.add(prog);
		pane.add(vprog);
		add(pane);
		setVisible(true);
	}
	@Override
	public void run() {
		try{
			generalFrame.unEnable();
			for(int i=0;i<5;i++){
				value = value + 100/5;
				vprog.setText("Complete - "+String.valueOf(value)+"%");
				prog.setValue(value);
				Thread.sleep(1000);
			}
			reduce();
			dispose();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public void reduce(){
		generalFrame.Enable();
	}
    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
        	JOptionPane.showMessageDialog(null, "This window can not be exited during Update.");
        } else {        
            super.processWindowEvent(e); 
        }
    }
}