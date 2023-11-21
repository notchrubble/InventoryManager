import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminPage {
	
	public static void showAdminPage() {
		
		JFrame frame = new JFrame("Admin Page");
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.gray);
		
		JButton b = AddToUI.button(panel, "Register Account", 2, 3, 10, 40, 650, 40);
		
		 b.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent e) {
	        		
	        		Register.createAcc();
	        		
	        		}
	        	});
		 
		 
		 frame.add(panel, BorderLayout.WEST);
		 frame.setSize(new Dimension(1280, 720));
		 frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
		 }
}
