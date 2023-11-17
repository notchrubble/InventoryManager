import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddToUI {
	
	static void label(JPanel panel, String input, int x, int y, int top, int left, int bottom, int right) {
		
		JLabel labelfield = new JLabel(input);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(top, left, bottom, right);
		panel.add(labelfield, gbc);
		
	}
	
	

	static JTextField userText(JPanel panel, int x, int y, int top, int left, int bottom, int right) {
		
		JTextField textfield = new JTextField(15);
		textfield.setPreferredSize(new Dimension(200, 35));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(top, left, bottom, right);
		panel.add(textfield, gbc);
		
		return textfield;		
	}
	
	static JPasswordField userPass(JPanel panel, int x, int y, int top, int left, int bottom, int right) {
		
		JPasswordField passfield = new JPasswordField(15);
		passfield.setPreferredSize(new Dimension(200, 35));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(top, left, bottom, right);
		panel.add(passfield, gbc);
		
		return passfield;
	}
	
	static JButton button(JPanel panel, String input, int x, int y, int top, int left, int bottom, int right) {
		
		JButton buttonfield = new JButton(input);
		buttonfield.setPreferredSize(new Dimension(200, 35));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(top, left, bottom, right);
		panel.add(buttonfield, gbc);
		
		return buttonfield;
	}
	

}
