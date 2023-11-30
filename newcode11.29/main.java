import java.io.IOException;

//import classes.LoginPage;
//import classes.UserAccount;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UserAccount user = new UserAccount("userAccounts.txt");
		
		LoginPage loginPage = new LoginPage(user.getLoginInfo());
		
	}

}
