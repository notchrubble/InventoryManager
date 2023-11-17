import java.util.HashMap;
import java.util.Map;


public class AccountManager{
	
	static HashMap<String, String> user_accs = new HashMap<String, String>();
	
	
	static {
		user_accs.put("Admin", "Admin");
	}
	
	
	
	
	
	public static void addUser(String username, String password) {
		user_accs.put(username, password);
}
	
	
	
	
	
	public static boolean isValid(String username, String password) {
		if(user_accs.containsKey(username)){
			return true;
		}
		return false;
	}
	
	
	
	
	
	public static void display() {
		System.out.print(user_accs);
	}
}

