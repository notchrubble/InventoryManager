package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ProductPage extends JFrame implements ActionListener {
    private HashMap<String, HashMap<String, Double>> products = new HashMap<>();
    private JButton addButton, displayButton, backButton;

    public ProductPage() {
        setTitle("Product Page");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons
        addButton = new JButton("Add Product");
        displayButton = new JButton("Display Products");
        backButton = new JButton("Back");

        // Add action listeners to buttons
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
        backButton.addActionListener(this);

        // Add buttons to frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Prompt user for product, price and quantity input
            String product = JOptionPane.showInputDialog("Enter product name:");
            if (product == null || product.trim().equals("")) {
                return;
            }
            
            // Check if product already exists in hashmap
            if (products.containsKey(product)) {
                JOptionPane.showMessageDialog(null, "That product has already been added, please adjust the quantity or remove the product in the other window (not implemented yet)");
                return;
            }
            double price = -1;
            int quantity = -1;
            while (price < 0) {
                try {
                    price = Double.parseDouble(JOptionPane.showInputDialog("Enter price:"));
                    if (price < 0) {
                        JOptionPane.showMessageDialog(null, "Price must be a positive number.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Price must be a number.");
                }
            }
            while (quantity < 0) {
                try {
                    quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));
                    if (quantity < 0) {
                        JOptionPane.showMessageDialog(null, "Quantity must be a positive number.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Quantity must be a number.");
                }
            }

            // Add product, price and quantity to hashmap
            HashMap<String, Double> productDetails = new HashMap<>();
            productDetails.put("price", price);
            productDetails.put("quantity", (double) quantity);
            products.put(product, productDetails);
        } else if (e.getSource() == displayButton) {
            // Display hashmap contents
            StringBuilder sb = new StringBuilder();
            if (products.isEmpty()) {
                sb.append("No Products Added Yet");
            } else {
                sb.append("<html><div style='background-color: #D3D3D3; padding: 10px;'><h1>Products</h1>");
                for (String key : products.keySet()) {
                    HashMap<String, Double> productDetails = products.get(key);
                    double price = productDetails.get("price");
                    double quantity = productDetails.get("quantity");
                    sb.append("<p>Name: ").append(key).append("<br>Qty: ").append(quantity).append("<br>($").append(price).append(")</p>");
                }
                sb.append("</div></html>");
            }
            JTextPane textPane = new JTextPane();
            textPane.setContentType("text/html");
            textPane.setText(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textPane);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            JFrame displayFrame = new JFrame("Display Products");
            displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            displayFrame.add(scrollPane);
            displayFrame.setSize(800, 800);
            displayFrame.setVisible(true);
        } else if (e.getSource() == backButton) {
            try {
                FileWriter writer = new FileWriter("products.csv");
                for (String key : products.keySet()) {
                    HashMap<String, Double> productDetails = products.get(key);
                    double price = productDetails.get("price");
                    double quantity = productDetails.get("quantity");
                    writer.write(key + "," + price + "," + quantity + "\n");
                }
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            dispose();
        }
    }

    public static void main(String[] args) {
        ProductPage productPage = new ProductPage();
        productPage.setVisible(true);
    }
}
