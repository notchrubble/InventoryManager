package InventoryManager.src;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener{

	//create a frame
	JFrame frame = new JFrame("Login Page");
	JPanel rightPanel = new JPanel ();
	//ImageIcon
	ImageIcon image = new ImageIcon("distribution.png");
	JLabel imageLabel = new JLabel(image);
	
	//Buttons
	JButton loginButton = new JButton("Login");
	JButton clearButton = new JButton("Clear");
	
	
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	
	JLabel userIDLabel = new JLabel ("Username:");
	JLabel userPasswordLabel = new JLabel ("Password:");
	
	JLabel messageLabel = new JLabel();
	
	private HashMap<String, String> loginInfo = new HashMap<String, String>();
	private String adminUsername = "Admin";
	
	//constructor
	public LoginPage(HashMap<String, String>loginInfoOriginal){
		
		loginInfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		messageLabel.setBounds(25, 250, 300, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC,18));
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		clearButton.setBounds(225, 200, 100, 25);
		clearButton.setFocusable(false);
		clearButton.addActionListener(this);
		
		
		rightPanel.setBounds(400, 10, 390, 370);
		rightPanel.setBackground(new Color(224, 244, 255));
		rightPanel.setLayout(new GridLayout(3,1));
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setVerticalAlignment(JLabel.CENTER);
		rightPanel.add(new JLabel());
		rightPanel.add(imageLabel);
		rightPanel.add(new JLabel());
		
		frame.add(userIDLabel);
		frame.add(userIDField);
		frame.add(userPasswordLabel);
		frame.add(userPasswordField);
		frame.add(messageLabel);
		frame.add(loginButton);
		frame.add(clearButton);
		frame.add(rightPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == clearButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("");
		}
		
		if(e.getSource() == loginButton) {
			String username = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(loginInfo.containsKey(username)) {
				if(loginInfo.get(username).equals(password)) {
					
					//frame.dispose();
					if(username.equals(adminUsername)) {
						messageLabel.setForeground(Color.orange);
						messageLabel.setText("Welcome to admin page!");
						//go to Admin page
						try {
							new AdminPage();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					else {
						messageLabel.setForeground(Color.green);
						messageLabel.setText("Login Successfully!");
					//goto Inventory
						new Inventory();
					}
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Invalid password!");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Invalid username or password!");
			}
		}		

	}

}
