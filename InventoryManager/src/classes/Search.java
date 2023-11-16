package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Search extends JFrame {
    private HashMap<String, Integer> items;

    public Search() {
        setTitle("Search Page");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize items HashMap with some example data
        items = new HashMap<>();
        items.put("apple", 5);
        items.put("banana", 3);
        items.put("orange", 2);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt user for item to search for
                String searchItem = JOptionPane.showInputDialog(Search.this, "Enter item to search for (or type 'quit' to exit):");

                // Check if user pressed cancel or typed 'quit'
                if (searchItem == null || searchItem.equalsIgnoreCase("quit")) {
                    setVisible(false); // Hide the window
                    dispose(); // Close the window
                } else {
                    // Search for item in HashMap and display result
                    if (items.containsKey(searchItem)) {
                        JOptionPane.showMessageDialog(Search.this, "Total number of " + searchItem + "s: " + items.get(searchItem));
                    } else {
                        JOptionPane.showMessageDialog(Search.this, "No item found under that name.");
                    }
                }
            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the window
                dispose(); // Close the window
            }
        });

        panel.add(searchButton);
        panel.add(closeButton);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        Search searchPage = new Search();
        searchPage.setVisible(true);
    }
}