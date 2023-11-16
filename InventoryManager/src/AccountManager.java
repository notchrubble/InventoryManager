import java.util.HashMap;

public class AccountManager {
	static HashMap<String, String> user_accs = new HashMap<String, String>();
	
	public static void addUser(String username, String password) {
		user_accs.put(username, password);

}
	public static void display() {
		System.out.print(user_accs);
	}
}
