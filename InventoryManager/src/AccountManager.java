import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


//Account Manager Class with methods that handle Account adding, Credential validation, Admin verification, and Account deletion.

public class AccountManager{
	//Creates a Hashmap "user_accs" with Key Value pairs both of type String.
	static HashMap<String, String> user_accs = new HashMap<String, String>();
	static {
		user_accs.put("admin", "admin");		//Statically initializes user_accs with key = admin and value = admin
	}
	//The above is the for admin account.
	
	
	
	
	
	//Creates an account by adding username as key and password as value inside of user_accs hashmap.
	public static void addUser(String username, String password) {
		user_accs.put(username, password);
		FileHandlerAcc.writeUserAccounts("files/userAccounts.txt");
		

	}
	 
	
	
	
	
	//Validates if user is legit by cross referencing entered username and password with those already populated in user_accs.
	//If the password of a non existent account is found it will be null and will return false.
	//If the password entered does not match with the username in user_accs then return false.
	//Return true otherwise.
	public static boolean isValid(String username, String password) {
		
		String storedPassword = user_accs.get(username);
		return storedPassword != null && storedPassword.equals(password);
	}
	
	
	
	
	
	//Validates if credentials entered belong to Admin, if username entered exists in user_accs and username = "admin" then cross reference password.
	//If password entered does not equal password matching with admin then return false.
	public static boolean isAdmin(String username, String password) {
		String storedPassword = user_accs.get(username);
		
		if (user_accs.containsKey(username) && username.equalsIgnoreCase("admin")){
			return storedPassword.equals(password);		
		}
		return false;
	}
	
	
	
	
	
	public static void display() {
		System.out.print(user_accs);
	}
	
	
	
	
	
    public static void createAcc() {
        JFrame inputFrame = new JFrame("Create your Account!");
        inputFrame.setSize(300, 150);
        inputFrame.setResizable(false);

        JPanel inputPanel = new JPanel();

        JTextField u = AddToUI.userText(inputPanel, 1, 0, 10, 0, 0, 0);
        JPasswordField p = AddToUI.userPass(inputPanel, 1, 1, 10, 0, 0, 0);

        JButton createAccount = AddToUI.button(inputPanel, "Create Account", 0, 0, 0, 0, 0, 0);

        createAccount.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String username = u.getText();
                char[] pchar = p.getPassword();
                String password = new String(pchar);
                AccountManager.addUser(username, password);
                AccountManager.display();
                FileHandlerAcc.writeUserAccounts(password);
                inputFrame.dispose();
                
            }
        });

        inputFrame.add(inputPanel);
        inputFrame.setVisible(true);
    }
	
	
}

