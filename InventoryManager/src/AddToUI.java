import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class AddToUI {
	
	 private static void addComponent(JPanel panel, Component component, int x, int y, int top, int left, int bottom, int right) {
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = x;
	        gbc.gridy = y;
	        gbc.insets = new Insets(top, left, bottom, right);
	        panel.add(component, gbc);
	    }
	
	//Builder Method to construct a JLabel with values passed in for x and y coords -- top, left, bottom, and right padding
	public static void label(JPanel panel, String input, int x, int y, int top, int left, int bottom, int right) {
		
		JLabel labelfield = new JLabel(input);
		addComponent(panel, labelfield, x, y, top, left, bottom, right);
	}
	
	public static void imageLabel(JPanel panel, ImageIcon image, int x, int y, int top, int left, int bottom, int right) {
		
		JLabel labelfield = new JLabel(image);
		addComponent(panel, labelfield, x, y, top, left, bottom, right);
	}
	
	
	//Builder Method to construct a JTextField using same methodology as above. Returns the textfield so that it is interactable after placement
	public static JTextField userText(JPanel panel, int x, int y, int top, int left, int bottom, int right) {
		
		JTextField textfield = new JTextField(15);
		textfield.setPreferredSize(new Dimension(200, 35));
		addComponent(panel, textfield, x, y, top, left, bottom, right);
		return textfield;		
	}
	
	//Builder Method to construct a JPassword field. Returns the JPassword so that it is interactable after placement.
	public static JPasswordField userPass(JPanel panel, int x, int y, int top, int left, int bottom, int right) {
		
		JPasswordField passfield = new JPasswordField(15);
		passfield.setPreferredSize(new Dimension(200, 35));
		addComponent(panel, passfield, x, y, top, left, bottom, right);
		return passfield;
	}
	
	//Builder Method to construct a JButton field. Returns the JButton so that it is interactable after placement.
	public static JButton button(JPanel panel, String input, int x, int y, int top, int left, int bottom, int right) {
		
		JButton buttonfield = new JButton(input);
		buttonfield.setPreferredSize(new Dimension(200, 35));
		addComponent(panel, buttonfield, x, y, top, left, bottom, right);
		return buttonfield;
	}
	
	public static JPopupMenu popMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		return popupMenu;
	}
	
	public static JToolBar createToolBar() {
		JToolBar toolbar = new JToolBar();
		
	    toolbar.add(Box.createHorizontalGlue());
	    toolbar.setOrientation(JToolBar.HORIZONTAL);
		toolbar.setBackground(Color.gray);
		toolbar.setPreferredSize(new Dimension(1000, 40));
		toolbar.setFloatable(false);
        toolbar.setBorderPainted(false);
        return toolbar;
	}
	

}
