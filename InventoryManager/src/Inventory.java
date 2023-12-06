import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class Inventory {
	
	private DefaultTableModel tableModel;
	
    public JPanel homePage() {
    	
    	
    	String[][]items = FileHandler.InventoryFromFile("files/inventorydatabase.txt");
        String[] itemTraits = { "Item Number", "Item Name", "Quantity", "Description", "Next Shipment", "Edit Information" };
        
        tableModel = new DefaultTableModel(items, itemTraits);       
        
        JTable table = new JTable(tableModel) {
        	public boolean isCellEditable(int row, int column) {
                return column == 5;   
            }
        };
        
     
        //table.setPreferredSize(new Dimension(1280, 720));
        
        ButtonRenderer buttonRenderer = new ButtonRenderer();
    	ButtonEditor buttonEditor = new ButtonEditor(new JTextField(), table);
        
        table.getColumnModel().getColumn(5).setCellRenderer(buttonRenderer);
        table.getColumnModel().getColumn(5).setCellEditor(buttonEditor);
        
        
        JPanel cardPanel = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel();
     
        infoPanel.setBackground(new Color(155,155,155));
        
    	ImageIcon icon = new ImageIcon("Art/profile.png");
    	ImageIcon addIcon = new ImageIcon("art/plus.png");
    	ImageIcon searchIcon = new ImageIcon("art/search.png");
    	ImageIcon homeIcon = new ImageIcon("art/icons8-home-40.png");
    	
    	
    	JLabel iconHolder = new JLabel(icon);
    	JLabel addIconHolder = new JLabel(addIcon);
    	JLabel searchHolder = new JLabel(searchIcon);
    	JLabel homeHolder = new JLabel(homeIcon);
    	
    	JLabel name = new JLabel();
    	JLabel quantity = new JLabel();
    	JLabel shipmentDate = new JLabel();
    	
    	infoPanel.add(name);
    	//infoPanel.add(quantity);
    	//infoPanel.add(shipmentDate);
 
        JToolBar toolBar = AddToUI.createToolBar(); 
  
        
        Font font = new Font("Arial", Font.BOLD, 24);
        name.setFont(font);
        name.setForeground(Color.white);
        
        
        
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
         
                        String itemName = table.getValueAt(selectedRow, 1).toString();
                        String itemQuantity = table.getValueAt(selectedRow, 2).toString();
                        String itemDate = table.getValueAt(selectedRow, 4).toString();
                        
                        
                        name.setText(itemName);
                      
                        quantity.setText(itemQuantity);
                        shipmentDate.setText(itemDate);
                        
                    }
                }
            }
        });
        
        
        
        JPopupMenu popupMenu = AddToUI.popMenu();
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem AddUser = new JMenuItem("Add User");

        
        popupMenu.add(logout);
        popupMenu.add(AddUser);
        toolBar.add(homeHolder);
        toolBar.add(searchHolder);
        toolBar.add(Box.createHorizontalStrut(1105));
        toolBar.add(addIconHolder);
        toolBar.add(iconHolder);
        cardPanel.add(toolBar, BorderLayout.NORTH);
        

        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800,640));
   
        infoPanel.setPreferredSize(new Dimension(cardPanel.getWidth()-scrollPane.getWidth(), cardPanel.getHeight()));
        
        cardPanel.add(scrollPane, BorderLayout.WEST);
        cardPanel.add(infoPanel);
 
        
          
        
        iconHolder.addMouseListener(new MouseAdapter() {	
        	public void mouseClicked(MouseEvent e) {
        		
        		popupMenu.show(iconHolder, 0, iconHolder.getHeight());
        		
        	}
        }); 
        
        addIconHolder.addMouseListener(new MouseAdapter() {
        	FileHandler handler = new FileHandler(table);
        	public void mouseClicked(MouseEvent e) {
        		
        		AddToUI.newItemDialogue(table);
        		handler.InventoryToFile("files/inventorydatabase.txt");
        		
        	}
        });   
        
        
        logout.addActionListener(new ActionListener() {	        	
        	public void actionPerformed(ActionEvent e) {
        		
        		Login.resetFields();
        		CardLayoutController.showLogin();
        		
        	}
        });  
        
        AddUser.addActionListener(new ActionListener() {	
        	public void actionPerformed(ActionEvent e) {
        		
        		AccountManager.createAcc();	
        		
        	}	
        });  
        
        searchHolder.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		AddToUI.searchItemDialogue(0, table);
        	}
        });   
        
      
        return cardPanel;
    }
}
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    private DefaultTableModel tableModel;

    public JPanel homePage() {
        ImageIcon icon = new ImageIcon("Art/profile.png");
        JLabel iconHolder = new JLabel(icon);
        JPanel cardPanel = new JPanel(new BorderLayout());

        JToolBar toolBar = AddToUI.createToolBar();
        toolBar.add(iconHolder);
        cardPanel.add(toolBar, BorderLayout.NORTH);

        JPopupMenu popupMenu = AddToUI.popMenu();
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem addUser = new JMenuItem("Add User");

        popupMenu.add(logout);
        popupMenu.add(addUser);

        String[][] items = readItemsFromFile("C:\\myvcsc131\\InventoryManager\\src\\inventorydatabase.txt");
        String[] itemTraits = { "Name", "Amount", "Other", "Edit", "Delete" };
        tableModel = new DefaultTableModel(items, itemTraits);
        JTable table = new JTable(tableModel) {
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4;
            }
        };

        // Adding 'Edit' and 'Delete' buttons to the table
        AddToUI.addButtonToTable(table, 3, "Edit", (tbl, row) -> {
            showEditDialog(row);
        });
        AddToUI.addButtonToTable(table, 4, "Delete", (tbl, row) -> {
            tableModel.removeRow(row);
            updateFileWithNewData();
        });

        JButton addButton = new JButton("Add New Item");
        addButton.addActionListener(e -> showAddNewItemDialog());
        toolBar.add(addButton);

        cardPanel.add(table, BorderLayout.CENTER);

        iconHolder.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                popupMenu.show(iconHolder, 0, iconHolder.getHeight());
            }
        });

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Login.resetFields();
                // CardLayoutController.showLogin();
            }
        });

        addUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // AccountManager.createAcc();
            }
        });

        return cardPanel;
    }

    private String[][] readItemsFromFile(String filePath) {
        ArrayList<String[]> itemList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] itemData = line.split(",");
                itemList.add(new String[] { itemData[0], itemData[1], itemData[2], "", "" });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList.toArray(new String[0][]);
    }

    private void showEditDialog(int row) {
        String itemName = (String) tableModel.getValueAt(row, 0);
        String itemAmount = (String) tableModel.getValueAt(row, 1);
        String itemOther = (String) tableModel.getValueAt(row, 2);

        JTextField nameField = new JTextField(itemName);
        JTextField amountField = new JTextField(itemAmount);
        JTextField otherField = new JTextField(itemOther);

        Object[] message = {
            "Name:", nameField,
            "Amount:", amountField,
            "Other:", otherField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Edit Item", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            tableModel.setValueAt(nameField.getText(), row, 0);
            tableModel.setValueAt(amountField.getText(), row, 1);
            tableModel.setValueAt(otherField.getText(), row, 2);
            updateFileWithNewData();
        }
    }

    private void updateFileWithNewData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventorydatabase.txt"))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                bw.write(tableModel.getValueAt(i, 0) + "," + tableModel.getValueAt(i, 1) + "," + tableModel.getValueAt(i, 2));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
        private void showAddNewItemDialog() {
            JTextField nameField = new JTextField();
            JTextField amountField = new JTextField();
            JTextField otherField = new JTextField();
    
            Object[] message = {
                "Name:", nameField,
                "Amount:", amountField,
                "Other:", otherField
            };
    
            int option = JOptionPane.showConfirmDialog(null, message, "Add New Item", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                tableModel.addRow(new Object[]{nameField.getText(), amountField.getText(), otherField.getText(), "", ""});
                updateFileWithNewData();
            }
        }
    }
    
