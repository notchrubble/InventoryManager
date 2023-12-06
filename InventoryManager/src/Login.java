import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Login extends AccountManager{
	
	private static JTextField username;
    private static JPasswordField password;
	
	public JPanel showLandingPage(){
		

		ImageIcon image = new ImageIcon("Art/loginart.png");
		JPanel imagePanel = new JPanel();
		
		JPanel cardPanel = new JPanel(new BorderLayout());
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(new Color(224,224,224));
		
		imagePanel.setPreferredSize(new Dimension(900, 720));
		
		username = AddToUI.userText(panel, 1, 0, 10, 0, 0, 80);			//Creates JTextField using a Builder Design Pattern Method.
		password = AddToUI.userPass(panel, 1, 1, 10, 0, 0, 80);		//Creates component using AddToUI method
		JButton b = AddToUI.button(panel, "Login", 1, 3, 10, 0, -100, 80);			//Passes through values for x and y, top, left, bottom, and right padding.
		AddToUI.imageLabel(imagePanel, image, 0, 0, 10, 40, 0, 0);
        AddToUI.label(panel, "Username", 0, 0, 10, 40, 0, 0);			//Creates username label
		AddToUI.label(panel, "Password", 0, 1, 10, 40, 0, 0);			//Creates password label.
        
        b.addMouseListener(new MouseAdapter() {							//Assigns a mouse listener to login button making it clickable.
        	
        	public void mouseClicked(MouseEvent e) {
        		login();
        	}
        }); 
        
        password.addKeyListener(new KeyAdapter() {						//Adds key listener to password field
        	
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_ENTER) {				//Checks if the enter key is pressed
        			login();
        		}
        	}
        });
        
        cardPanel.add(imagePanel, BorderLayout.EAST);
        cardPanel.add(panel, BorderLayout.WEST);
       
        return cardPanel;
	}
	
	private void login() {
		String usernameInput = username.getText();				//Once Login button is clicked, save username entered into a String variable.
		char[]pchar = password.getPassword();					//Once Login button is clicked, save password entered into a array of characters.
		String passwordInput = new String(pchar);				//Convert array of characters into string to save password entered.
		
		if (AccountManager.isValid(usernameInput, passwordInput)) {			//Passes username and password through boolean method to verify if Admin.
			CardLayoutController.showInven();
		}        		
	}
	
	public static void resetFields() {
		username.setText("");
		password.setText("");
	}
}
