import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Inventory {
	
	public static JFrame homePage() {
		
		JFrame homepage = new JFrame("Inventory Homepage");
		
		
		 
		 
	
		homepage.setSize(new Dimension(1280, 720));
		homepage.setLocationRelativeTo(null);
		homepage.setVisible(true);
		return homepage;
		 }
}
