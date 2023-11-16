import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class Login{
	
	public static void showLandingPage() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		JFrame frame = new JFrame("Inventory Manager");
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel usernameText = new JLabel("Username");
        JLabel passwordText = new JLabel("Password");
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JButton loginButton = new JButton("Login");
        
        panel.setBackground(Color.gray);
        gbc.insets = new Insets(10, 40, 0, 0);
        panel.add(usernameText, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 80);
        panel.add(usernameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 40, 0, 0);
        panel.add(passwordText, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 80);
        panel.add(passwordField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(loginButton, gbc);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);
	}

}