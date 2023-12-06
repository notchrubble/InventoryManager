package classes;
import javax.swing.JFrame;

public class Inventory {
	
	JFrame frame = new JFrame("Inventory Page");
	
	Inventory(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
