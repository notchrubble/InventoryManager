import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;



public class Login extends AccountManager{

	public static void showLandingPage(){
		
		JFrame frame = new JFrame("Inventory Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.gray);
		
		JTextField username = AddToUI.userText(panel, 1, 0, 10, 0, 0, 80);
		JPasswordField password = AddToUI.userPass(panel, 1, 1, 10, 0, 0, 80);
				
        AddToUI.label(panel, "Username", 0, 0, 10, 40, 0, 0);
		AddToUI.label(panel, "Password", 0, 1, 10, 40, 0, 0);
        
		JButton b = AddToUI.button(panel, "Login", 1, 3, 10, 0, -100, 80);
  
        b.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		
        		String usernameInput = username.getText();
        		char[]pchar = password.getPassword();
        		String passwordInput = new String(pchar);
        		
        		if (AccountManager.isAdmin(usernameInput, passwordInput)) {
        			AdminPage.showAdminPage();
        		}
        		
        		
        		
        	}
        });     
        
        

        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);
       
	}
	
}

