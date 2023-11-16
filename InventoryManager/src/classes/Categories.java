package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Categories extends JFrame implements ActionListener {
    private JButton viewButton;
    private JButton addButton;
    private JButton backButton;

    public Categories() {
        setTitle("Categories Page");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons
        viewButton = new JButton("View Categories");
        addButton = new JButton("Add Category");
        backButton = new JButton("Back");

        // Add action listeners to buttons
        viewButton.addActionListener(this);
        addButton.addActionListener(this);
        backButton.addActionListener(this);

        // Add buttons to content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));
        contentPane.add(viewButton);
        contentPane.add(addButton);
        contentPane.add(backButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            // Code to view existing categories
            System.out.println("Viewing existing categories...");
        } else if (e.getSource() == addButton) {
            // Add a category
            System.out.println("Adding a category...");
        } else if (e.getSource() == backButton) {
            // Code to go back to previous page
            dispose();
        }
    }

    public static void main(String[] args) {
        Categories CategoriesPage = new Categories();
        CategoriesPage.setVisible(true);
    }
}
