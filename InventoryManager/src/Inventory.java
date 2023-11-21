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
	
	public static JPanel showAdminPage() {
		
		JFrame AdminFrame = new JFrame("Admin Page");
		
		JPanel AdminPanel = new JPanel(new GridBagLayout());
		AdminPanel.setBackground(Color.gray);
		
		JButton b = AddToUI.button(AdminPanel, "Register Account", 2, 3, 10, 40, 650, 40);
		
		 b.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent e) {
	        		
	        		Register.createAcc();
	        		
	        		}
	        	});
		 
		 
		 AdminFrame.add(AdminPanel, BorderLayout.WEST);
		 AdminFrame.setSize(new Dimension(1280, 720));
		 AdminFrame.setLocationRelativeTo(null);
		 AdminFrame.setVisible(true);
		 return AdminPanel;
		 }
}
