import java.util.HashMap;
import java.util.Map;


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
	
	
}

