//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package addCarFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import overideClasses.Panel;

public class imagePanel extends Panel implements ListSelectionListener{
	private JLabel image;
    private static String[] namesList = {"1.png","2.png","3.png","4.png"};
    private static JList<String> listScrollPane;
	public imagePanel(){
        image = new JLabel();
        listScrollPane = new JList<String>(namesList);
        listScrollPane.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listScrollPane.setSelectedIndex(0);
        listScrollPane.addListSelectionListener(this);
        JScrollPane scrollPane = new JScrollPane(listScrollPane);
        JScrollPane imagesScrollPane = new JScrollPane(image);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane, imagesScrollPane);
        splitPane.setPreferredSize(new Dimension(300, 200));
        image.setIcon(new ImageIcon(this.getClass().getResource("/images/vehicles/"+namesList[listScrollPane.getSelectedIndex()])));
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
        splitPane.setDividerLocation(0.5);
        splitPane.setBounds(new Rectangle(new Point(10,90),splitPane.getPreferredSize()));
        openFilePanel ofpane = new openFilePanel();
        ofpane.setBounds(new Rectangle(new Point(340,90),splitPane.getPreferredSize()));
        add(ofpane);
        add(splitPane);
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		image.setIcon(new ImageIcon(this.getClass().getResource("/images/vehicles/"+namesList[listScrollPane.getSelectedIndex()])));
	}
	public static String getSelected(){
		return namesList[listScrollPane.getSelectedIndex()];
	}
}
