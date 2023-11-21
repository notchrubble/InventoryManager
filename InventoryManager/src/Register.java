import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register {
	
	public static void createAcc() {
		
		
		 JFrame inputFrame = new JFrame("Create your Account!");
	     inputFrame.setSize(300, 150);
	     inputFrame.setResizable(false);
	     
	     JPanel inputPanel = new JPanel();
	     
	     JTextField u = AddToUI.userText(inputPanel, 1, 0, 10, 0, 0, 0);
	     JPasswordField p = AddToUI.userPass(inputPanel, 1, 1, 10, 0, 0, 0);
	     
	

	     
	     JButton createAccount = AddToUI.button(inputPanel, "Create Account", 0, 0, 0, 0, 0, 0);
	     
	     createAccount.addMouseListener(new MouseAdapter() {
	  
	        	    	
	      public void mouseClicked(MouseEvent e) {
	    	  
	    	 String username = u.getText();
	    	 
	 	     char[]pchar = p.getPassword();
	 	     String password = new String(pchar);
	    	 
	    	 AccountManager.addUser(username, password);
	    	 //AccountManager.display();
	    	 
	        	    	}  	    	
	        	    });
	      
	      inputFrame.add(inputPanel);
	      inputFrame.setVisible(true);
	        
	}
	

}
