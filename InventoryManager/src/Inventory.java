import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

public class Inventory extends Login {

    public static JFrame homePage(String usernameInput, String passwordInput) {

    	ImageIcon icon = new ImageIcon("Art/profile.png");
    	 
        JFrame frame = new JFrame("Admin Page");
      
        JToolBar toolBar = AddToUI.createToolBar();      
        JLabel label = new JLabel(icon);
        
        JPopupMenu popupMenu = AddToUI.popMenu();
 
        toolBar.add(label);
        frame.add(toolBar, BorderLayout.NORTH);
           
        JMenuItem logout = new JMenuItem("Logout");
        popupMenu.add(logout);
        
        JMenuItem AddUser = new JMenuItem("Add User");
        
        
        
        
        
        if (AccountManager.isAdmin(usernameInput, passwordInput)) {
        	popupMenu.add(AddUser);
        }
        
 
        
        
        label.addMouseListener(new MouseAdapter() {						
        	
        	public void mouseClicked(MouseEvent e) {
      
        		popupMenu.show(label, 0, label.getHeight());
        		
        	}
        });     
        
        logout.addMouseListener(new MouseAdapter() {	
        	
        	public void mouseClicked(MouseEvent e) {
        
        		
        	
        	}
        });  
        
        
        

   
        
        
        

       
        frame.setSize(new Dimension(1280, 720));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        return frame;
    }
}