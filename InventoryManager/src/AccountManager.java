import java.util.HashMap;
import java.util.Map;


public class AccountManager{
	
	static HashMap<String, String> user_accs = new HashMap<String, String>();
	static {
		user_accs.put("admin", "admin");
	}
	
	
	
	
	public static void addUser(String username, String password) {
		user_accs.put(username, password);

	}
	
	
	
	
	
	public static boolean isValid(String username, String password) {
		String storedPassword = user_accs.get(username);
		return storedPassword != null && storedPassword.equalsIgnoreCase(password);
	}
	
	
	
	
	
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

