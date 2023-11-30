import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;

public class ChangePassword implements ActionListener {
	JFrame frame = new JFrame("Change Password");
	
	JLabel username = new JLabel("Username: ");
	JLabel oldPwd = new JLabel("Current Password");
	JLabel newPwd = new JLabel("New Password"); 
	
	JTextField usernameText = new JTextField();
	JPasswordField oldPwdField = new JPasswordField();
	JPasswordField newPwdField = new JPasswordField();
	
	JButton done = new JButton("Done");
	JButton cancel = new JButton("Cancel");
	
	private HashMap <String, String> loginInfo = new HashMap <String, String>();
	private String accountFile = "userAccounts.txt";
	private UserAccount account;
	
	public ChangePassword(HashMap <String, String> loginInfoOriginal) throws IOException {
		this.loginInfo = loginInfoOriginal;
		account = new UserAccount(accountFile);
		
		username.setBounds(50, 100, 100, 25);
		oldPwd.setBounds(50, 150, 100, 25);
		newPwd.setBounds(50, 200, 100, 25);
		
		usernameText.setBounds(150, 100, 200, 25);
		oldPwdField.setBounds(150, 150, 200, 25);
		newPwdField.setBounds(150, 200, 200, 25);
		
		done.setBounds(150, 250, 75, 25);
		done.setFocusable(false);
		done.addActionListener(this);
		
		cancel.setBounds(250, 250, 75, 25);
		cancel.setFocusable(false);
		cancel.addActionListener(this);
		
		frame.add(username);
		frame.add(oldPwd);
		frame.add(newPwd);
		frame.add(usernameText);
		frame.add(oldPwdField);
		frame.add(newPwdField);
		frame.add(done);
		frame.add(cancel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(620, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cancel) {
			frame.dispose();
			new LoginPage(account.getLoginInfo());
		}
		if(e.getSource() == done) {
			String username = usernameText.getText();
			String oldPassword = String.valueOf(oldPwdField.getPassword());
			String newPassword = String.valueOf(newPwdField.getPassword());
			
			if(loginInfo.containsKey(username)) {
				if(loginInfo.get(username).equals(oldPassword)) {
					try {
						account.updatePassword(username, newPassword);
						new LoginPage(account.getLoginInfo());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid username or current password");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid username or current password");
			}
		}
		
	}
}
