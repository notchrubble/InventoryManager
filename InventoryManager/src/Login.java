import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;






public class Login implements ActionListener{

	JButton createButton;
	JLabel RegisterLabel = new JLabel("Don't have an account? Sign up here!");
	JButton LoginButton = new JButton("Login");
	JLabel PasswordText = new JLabel("Password");
	JLabel UsernameText = new JLabel("Username");
	
	
	
	
	public void showLandingPage(){
		
		JFrame frame = new JFrame("Inventory Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.gray);
        
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        usernameField.setPreferredSize(new Dimension(200, 35));
        passwordField.setPreferredSize(new Dimension(200, 35));
        
        LoginButton.addActionListener(Login.this);
        LoginButton.setPreferredSize(new Dimension(200, 35));
       
        AddToUI(panel, usernameField, 1,0,10,0,0,80);
        AddToUI(panel, UsernameText, 0,0,10,40,0,0);
        
        AddToUI(panel, passwordField, 1,1,10,0,0,80); 
        AddToUI(panel, PasswordText, 0,1,10,40,0,0); 
        
        AddToUI(panel, LoginButton, 1,3,10,0,-100,80);
        AddToUI(panel, RegisterLabel, 1,2,10,0,-160,80); 
    
        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);
       
        RegisterLabel.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		CreateAcc();
        	}
        });     
	}
	
	
	
	
	
	private static void AddToUI (JPanel panel, Component comp, int x, int y, int top, int left, int bottom, int right) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(top, left, bottom, right);
		panel.add(comp, gbc);
	}
	
	
	
	
	
	public void CreateAcc() {
		
		 JFrame inputFrame = new JFrame("Create your Account!");
	     inputFrame.setSize(300, 150);
	     inputFrame.setResizable(false);
	     
	     JPanel inputPanel = new JPanel();
	     JTextField newUserField = new JTextField(15);
	     JPasswordField newPassField = new JPasswordField(15);
	        		
	     createButton = new JButton("Create Account");
	     createButton.addMouseListener(new MouseAdapter() {
	  
	        	    	
	      public void mouseClicked(MouseEvent e) {
	    	  String user = newUserField.getText();
	    	  char[]cpass = newPassField.getPassword();
	    	  String pass = new String(cpass);
	        	    		
	    	  AccountManager.addUser(user, pass);
	    	  AccountManager.display();
	        	    	}  	    	
	        	    });
	      
	      AddToUI(inputPanel, UsernameText, 0, 0, 10, 0, 0, 0);
	      AddToUI(inputPanel, newUserField, 1, 0, 10, 0, 0, 0);
	      AddToUI(inputPanel, PasswordText, 0, 1, 10, 0, 0, 0);
	      AddToUI(inputPanel, newPassField, 1, 1, 10, 0, 0, 0);
	      AddToUI(inputPanel, createButton, 2, 2, 10, 0, 0, 0);
	           
	      inputFrame.add(inputPanel);
	      inputFrame.setVisible(true);
	        
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == LoginButton) {
			AccountManager.addUser("hello", "Test1");
			AccountManager.display();
		}
	}
	
}

