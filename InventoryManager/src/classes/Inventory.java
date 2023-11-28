package classes;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import classes.ProductPage;
import classes.Categories;
import classes.Search;

public class Inventory {

	JFrame frame = new JFrame("Inventory Page");
	// Create the buttons
		JButton productsButton = new JButton("Products Page");
		JButton categoriesButton = new JButton("Categories");
		JButton searchButton = new JButton("Search");

	Inventory(){

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 420);
		frame.setLayout(null);
		frame.setVisible(true);

		// Set the button positions and sizes
		productsButton.setBounds(50, 50, 200, 50);
		categoriesButton.setBounds(50, 110, 200, 50);
		searchButton.setBounds(50, 170, 200, 50);

		// Add the buttons to the frame
		frame.add(productsButton);
		frame.add(categoriesButton);
		frame.add(searchButton);

		// Add action listeners to the buttons
		productsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Open the ProductsPage
				ProductPage productPage = new ProductPage();
				productPage.setVisible(true);
			}
		});

		categoriesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Open the CategoriesPage
				Categories categoriesPage = new Categories();
				categoriesPage.setVisible(true);
			}
		});

		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Open the SearchPage
				Search searchPage = new Search();
				searchPage.setVisible(true);
			}
		});
	}

}
