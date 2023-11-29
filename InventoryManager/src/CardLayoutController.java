import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardLayoutController {
	
	private static JFrame frame;
	private static JPanel cardPanel;
	private static CardLayout cardLayout;
	private static Login loginCard;
	private static Inventory invenCard;
	private static boolean flag = false;
	
	
	private CardLayoutController() {
		
	}
	
	public static void initialize() {
		frame = new JFrame("Card Layout Controller");
		cardPanel = new JPanel(new CardLayout());
		cardLayout = (CardLayout) cardPanel.getLayout();
		
		loginCard = new Login();
		invenCard = new Inventory();
	
		cardPanel.add(loginCard.showLandingPage(), "Login");
		cardPanel.add(invenCard.homePage(), "Inventory");
		
		frame.getContentPane().add(cardPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		flag = true;
	}
	
	
	
	public static void showLogin() {
		if(flag == false) {
			initialize();
		}
		frame.setTitle("Login");
		cardLayout.show(cardPanel, "Login");

		
	}
	public static void showInven() {
		frame.setTitle("Inventory Homepage");
		cardLayout.show(cardPanel, "Inventory");
	}
}
