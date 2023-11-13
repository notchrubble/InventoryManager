import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Login{
	
	public static void showLandingPage() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JFrame frame = new JFrame("Inventory Manager");
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.gray);
		
		JLabel usernameText = new JLabel("Username");
        JLabel passwordText = new JLabel("Password");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel addAccount = new JLabel("Don't have an account? Sign up here!");
     
     
        usernameField.setPreferredSize(new Dimension(200, 35));
        passwordField.setPreferredSize(new Dimension(200, 35));
        loginButton.setPreferredSize(new Dimension(200, 35));
        
  
        addAccount.setFont(new Font("Arial", Font.PLAIN, 12));
        addAccount.setForeground(Color.orange);
        addAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addAccount.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		JOptionPane.showMessageDialog(frame, "This page will pop up with two text boxes to register a new username and password");
        	}
        });
 
        
        AddToUI(panel, usernameText, 0,0,10,40,0,0);
        AddToUI(panel, usernameField, 1,0,10,0,0,80);
        AddToUI(panel, passwordText, 0,1,10,40,0,0); 
        AddToUI(panel, passwordField, 1,1,10,0,0,80);  
        AddToUI(panel, addAccount, 1,2,10,0,-160,80);
        AddToUI(panel, loginButton, 1,3,10,0,-100,80);
   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);
	}
	
	private static void AddToUI (JPanel panel, Component comp, int x, int y, int top, int left, int bottom, int right) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(top, left, bottom, right);
		panel.add(comp, gbc);
		
		
	}
	
	
	
	
	

}
