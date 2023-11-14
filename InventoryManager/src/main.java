package InventoryManager.src;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UserAccount user = new UserAccount("userAccounts.txt");
		
		LoginPage loginPage = new LoginPage(user.getLoginInfo());
		
	}

}
