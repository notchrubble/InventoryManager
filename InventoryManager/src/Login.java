import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


//This class extends AccountManager, so that this class may inherit the values and methods of AccountManager class.
public class Login extends AccountManager{



	public static JFrame showLandingPage(){
		
		ImageIcon image = new ImageIcon("Art/cart.jpg");
		
		JFrame frame = new JFrame("Inventory Manager");
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.gray);
		
		JPanel imagePanel = new JPanel();
		
		JTextField username = AddToUI.userText(panel, 1, 0, 10, 0, 0, 80);			//Creates JTextField using a Builder Design Pattern Method.
		JPasswordField password = AddToUI.userPass(panel, 1, 1, 10, 0, 0, 80);		//Creates component using AddToUI method
		JButton b = AddToUI.button(panel, "Login", 1, 3, 10, 0, -100, 80);			//Passes through values for x and y, top, left, bottom, and right padding.
		
	
		AddToUI.imageLabel(imagePanel, image, 0, 0, 10, 40, 0, 0);
        AddToUI.label(panel, "Username", 0, 0, 10, 40, 0, 0);			//Creates username label
		AddToUI.label(panel, "Password", 0, 1, 10, 40, 0, 0);			//Creates password label.
        
  
        b.addMouseListener(new MouseAdapter() {							//Assigns a mouse listener to login button making it clickable.
        	
        	public void mouseClicked(MouseEvent e) {
        		String usernameInput = username.getText();				//Once Login button is clicked, save username entered into a String variable.
        		char[]pchar = password.getPassword();					//Once Login button is clicked, save password entered into a array of characters.
        		String passwordInput = new String(pchar);				//Convert array of characters into string to save password entered.
        		
        		if (AccountManager.isValid(usernameInput, passwordInput)) {			//Passes username and password through boolean method to verify if Admin.
      		
        			Inventory.homePage(passwordInput, passwordInput);			//If credentials validated as admin, show the inventory page for Admins.
        			frame.dispose();				
        			
        		}        		
        	}
        }); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(imagePanel, BorderLayout.EAST);
        frame.add(panel, BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);							//Sets frame to be visible to the user.
        return frame;
	}
	
}

