package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ProductPage extends JFrame implements ActionListener {
    private HashMap<String, Integer> products = new HashMap<>();
    private JButton addButton, displayButton, quitButton;

    public ProductPage() {
        setTitle("Product Page");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons
        addButton = new JButton("Add Product");
        displayButton = new JButton("Display Products");
        quitButton = new JButton("Quit");

        // Add action listeners to buttons
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
        quitButton.addActionListener(this);

        // Add buttons to frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Prompt user for product and quantity input
            String product = JOptionPane.showInputDialog("Enter product name:");
            int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));

            // Add product and quantity to hashmap
            products.put(product, quantity);
        } else if (e.getSource() == displayButton) {
            // Display hashmap contents
            JOptionPane.showMessageDialog(null, products.toString());
        } else if (e.getSource() == quitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ProductPage productPage = new ProductPage();
        productPage.setVisible(true);
    }
}
