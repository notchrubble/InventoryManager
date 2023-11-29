import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTable;
import javax.swing.JToolBar;

public class Inventory {

    public JPanel homePage() {

    	ImageIcon icon = new ImageIcon("Art/profile.png");
    	JLabel iconHolder = new JLabel(icon);
        JPanel cardPanel = new JPanel();
        
        JToolBar toolBar = AddToUI.createToolBar(); 
        toolBar.add(iconHolder);
        cardPanel.add(toolBar, BorderLayout.NORTH);
       
        JPopupMenu popupMenu = AddToUI.popMenu();
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem AddUser = new JMenuItem("Add User");
        
        popupMenu.add(logout);
        popupMenu.add(AddUser);
        
        
        String [][] items = {
        		{"item1", "Quantity", "Other value" },
        		{"item2", "Quantity 2", "Other value 2"}
        };
        
        String [] itemTraits = {"Name", "Amount", "Other"};
      
        JTable table = AddToUI.createTable(cardPanel, itemTraits, items, 0, 1, 10, 0, 0, 0);
        
        
        
        iconHolder.addMouseListener(new MouseAdapter() {						
        	public void mouseClicked(MouseEvent e) {
        		popupMenu.show(iconHolder, 0, iconHolder.getHeight());
        	}
        });     
        
        
        logout.addActionListener(new ActionListener() {	        	
        	public void actionPerformed(ActionEvent e) {
        		Login.resetFields();
        		CardLayoutController.showLogin();
        	}
        });  
        
        
        AddUser.addActionListener(new ActionListener() {	
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		AccountManager.createAcc();
   
        		
        	
        	}
        	
        });  
        
        
        
        
        
        
        

        

        return cardPanel;
    }
}