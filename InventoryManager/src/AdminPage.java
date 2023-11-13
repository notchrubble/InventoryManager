package InventoryManager.src;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminPage implements ActionListener {
	JFrame frame = new JFrame("Admin Page");
	JPanel rightPanel = new JPanel();
	
	JLabel userName = new JLabel("New username");
	JLabel password = new JLabel("New Password");
	
	JTextField userNameText = new JTextField();
	//change to Password field
	JTextField passwordText = new JTextField();//have a toggle to show password
	
	JLabel message = new JLabel();
	
	JButton register = new JButton("Register");
	JButton clear = new JButton("Clear");
	JButton	gotoInventory = new JButton("Go to Inventory");
	
	//HashMap <String, String> loginInfo = new HashMap <String, String>();
	
	AdminPage (){
		userName.setBounds(50, 100, 100, 25);
		password.setBounds(50, 150, 100, 25);
		
		userNameText.setBounds(150, 100, 200, 25);
		passwordText.setBounds(150, 150, 200, 25);
		
		register.setBounds(140, 200, 150, 25);
		register.setFocusable(false);
		register.addActionListener(this);
		
		clear.setBounds(280, 200, 75, 25);
		clear.setFocusable(false);
		clear.addActionListener(this);
		
		gotoInventory.setBounds(470, 350, 150, 25);
		gotoInventory.setFocusable(false);
		gotoInventory.addActionListener(this);
		
		message.setBounds(25, 250, 300, 35);
		message.setFont(new Font(null, Font.ITALIC, 18));
		
		frame.add(userName);
		frame.add(userNameText);
		frame.add(password);
		frame.add(passwordText);
		frame.add(register);
		frame.add(clear);
		frame.add(message);
		frame.add(gotoInventory);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(620, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == clear) {
			userNameText.setText("");
			passwordText.setText("");
			message.setText("");
		}
		
		if(e.getSource() == register) {
			String username = userNameText.getText();
			String pwd = passwordText.getText();
			
			if(username.isEmpty() || pwd.isEmpty()) {
				message.setForeground(Color.red);
				message.setText("Missing username or password");
			}
//			else {
//				UserAccount user = new UserAccount(username, pwd);
//				message.setForeground(Color.orange);
//				message.setText("User account added successfully!");
//				userNameText.setText("");
//				passwordText.setText("");
//				user.printAccount();
//			}
//			
			
		}
		if(e.getSource() == gotoInventory) {
			frame.dispose();
			new Inventory();
		}
		
	}
}
