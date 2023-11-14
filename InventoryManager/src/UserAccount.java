package InventoryManager.src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UserAccount {
	private HashMap <String, String> loginInfo = new HashMap <String, String>();
	private String accountFile;
	
	public UserAccount (String accountFile) throws IOException{
		this.accountFile = accountFile;
		loginInfo = loadAccounts();
	}

	public HashMap<String, String> loadAccounts() throws IOException{
		
		HashMap<String, String> listAccounts = new HashMap<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(accountFile))) {
			String line;
			
			while((line = reader.readLine()) != null) {
				String[] parts = line.split(":");
				
				if(parts.length == 2) {
					String username = parts[0].replaceAll("[^a-zA-Z0-9]", "");
					String password = parts[1].replaceAll("[^a-zA-Z0-9]", "");
					listAccounts.put(username, password);
					System.out.println(username + " "+ password);
				}
				printAccount();
			}
		}
		System.out.println(accountFile);
		
		return listAccounts;
	}
	
	public void registerAccount (String usernam, String pwd) throws IOException {
		loginInfo.put(usernam, pwd);
		saveAccounts();
	}
	
	public void saveAccounts() throws IOException {
		try (PrintWriter writer = new PrintWriter (new FileWriter(accountFile))) {
			for (HashMap.Entry <String, String> entry : loginInfo.entrySet()) {
				writer.println(entry.getKey() + ":" + entry.getValue());
				System.out.println(entry.getKey()+ " " + entry.getValue());
			}
		}
	}
	
	public HashMap<String, String> getLoginInfo () {
		return loginInfo;
	}
	
	public void printAccount() {
		for (Map.Entry<String, String> entry : loginInfo.entrySet()) {
			System.out.println("Username: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}

}
