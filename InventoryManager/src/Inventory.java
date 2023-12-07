import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class Inventory {
	
	private DefaultTableModel tableModel;
	
    public JPanel homePage() {
    	
    	
    	String[][]items = FileHandler.InventoryFromFile("files/inventorydatabase.txt");
        String[] itemTraits = { "Item Number", "Item Name", "Quantity", "Description", "Next Shipment", "Edit Information", "Delete Item" };
        
        tableModel = new DefaultTableModel(items, itemTraits);       
        
        JTable table = new JTable(tableModel) {
        	public boolean isCellEditable(int row, int column) {
                return column == 5 || column == 6;   
            }
        };
        
     
        //table.setPreferredSize(new Dimension(1280, 720));
        
        ButtonRenderer buttonRenderer = new ButtonRenderer();
    	ButtonEditor buttonEditor = new ButtonEditor(new JTextField(), table);
        ButtonRendererDelete buttonRendererDelete = new ButtonRendererDelete();
    	ButtonDelete buttonDelete = new ButtonDelete(new JTextField(), table);

        table.getColumnModel().getColumn(5).setCellRenderer(buttonRenderer);
        table.getColumnModel().getColumn(5).setCellEditor(buttonEditor);
        table.getColumnModel().getColumn(6).setCellRenderer(buttonRendererDelete);
        table.getColumnModel().getColumn(6).setCellEditor(buttonDelete);
        
        
        JPanel cardPanel = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel();
        infoPanel.setVisible(false);
        infoPanel.setBackground(new Color(155, 155, 155));
        
        JScrollPane scrollPane = new JScrollPane(table);
    
        scrollPane.setPreferredSize(new Dimension(1280,640));
        
        ImageIcon profileIcon = new ImageIcon("Art/profile.png");
    	ImageIcon addItemIcon = new ImageIcon("art/plus.png");
    	ImageIcon searchItemIcon = new ImageIcon("art/search.png");
    	JLabel profileIconHolder = new JLabel(profileIcon);
    	JLabel addIconHolder = new JLabel(addItemIcon);
    	JLabel searchIconHolder = new JLabel(searchItemIcon);
    	
    	
    	Font font = new Font("Work Sans", Font.BOLD, 24);
    	JLabel name = new JLabel();
    	JLabel quantity = new JLabel();
    	JLabel shipmentDate = new JLabel();
    	JLabel desc = new JLabel();
    	
    	JLabel quantityGUIText = new JLabel("Items in Stock:");
    	JLabel shipmentDateGUIText = new JLabel("Next Expected Shipment Date:");
    	JLabel descGUIText = new JLabel("Item Description:");
    	
   
    	
    	name.setFont(font);
        name.setForeground(new Color(55,55,55));
        quantity.setForeground(Color.red);
        shipmentDate.setForeground(Color.green);
    	
        
        JPanel quantityTextPanel = AddToUI.createBlackBoxPanel(quantityGUIText);
        JPanel dateTextPanel = AddToUI.createBlackBoxPanel(shipmentDateGUIText);
        JPanel descTextPanel = AddToUI.createBlackBoxPanel(descGUIText);
        
    	JPanel namePanel = AddToUI.createBlackBoxPanel(name);
        JPanel quantityPanel = AddToUI.createBlackBoxPanel(quantity);
        JPanel shipmentDatePanel = AddToUI.createBlackBoxPanel(shipmentDate);
        JPanel itemDescPanel = AddToUI.createBlackBoxPanel(desc);
        
        JToolBar toolBar = AddToUI.createToolBar(); 
        toolBar.add(searchIconHolder);
        toolBar.add(Box.createHorizontalStrut(1150));
        toolBar.add(addIconHolder);
        toolBar.add(profileIconHolder);
     
        JPopupMenu popupMenu = AddToUI.popMenu();
        JMenuItem logoutButton = new JMenuItem("Logout");
        JMenuItem AddUserButton = new JMenuItem("Add User");
        popupMenu.add(logoutButton);
        popupMenu.add(AddUserButton);
        
        
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
            	 infoPanel.setPreferredSize(new Dimension(cardPanel.getWidth()-800, cardPanel.getHeight()));
                 infoPanel.removeAll(); // Remove existing components before adding new ones
                 infoPanel.setLayout(new GridBagLayout());
                 
                 AddToUI.addToInfoPanel(infoPanel, quantityTextPanel, 0, 0, -300, -365, 0, 0);
                 AddToUI.addToInfoPanel(infoPanel, quantityPanel, 0, 0, -300, -235, 0, 0);
                 
                 AddToUI.addToInfoPanel(infoPanel, dateTextPanel, 0, 0, -250, -268, 0, 0);
                 AddToUI.addToInfoPanel(infoPanel, shipmentDatePanel, 0, 0, -250, -5, 0, 0);
                 
                 
                 
                 AddToUI.addToInfoPanel(infoPanel, descTextPanel, 0, 0, 0, 0, 0, 0);
                 AddToUI.addToInfoPanel(infoPanel, itemDescPanel, 0, 0, 50, 0, 0, 0);
                 
                 
                 AddToUI.addToInfoPanel(infoPanel, namePanel, 0, 0, -600, -0, 0, 0);
             
                 infoPanel.revalidate(); // Revalidate the panel to reflect changes
                 infoPanel.repaint();
                 
                 scrollPane.setPreferredSize(new Dimension(800,640));
                 infoPanel.setVisible(true);
  
                 cardPanel.add(infoPanel);
             
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                    
                        String itemName = table.getValueAt(selectedRow, 1).toString().toUpperCase();
                        String itemQuantity = table.getValueAt(selectedRow, 2).toString();
                        String itemDesc = table.getValueAt(selectedRow, 3).toString();
                        String itemDate = table.getValueAt(selectedRow, 4).toString(); 
                             
                        name.setText(itemName);
                        quantity.setText(itemQuantity);
                        shipmentDate.setText(itemDate);
                        desc.setText(itemDesc);
              
                  
                        
                    }
                }
            }
        });
        
        
        


            
            // Add the delete button to the toolbar
      
     
     
     
        cardPanel.add(toolBar, BorderLayout.NORTH);
        
        cardPanel.add(scrollPane, BorderLayout.WEST);
       
 
        
          
        
        profileIconHolder.addMouseListener(new MouseAdapter() {	
        	public void mouseClicked(MouseEvent e) {
        		
        		popupMenu.show(profileIconHolder, 0, profileIconHolder.getHeight());
        		
        	}
        }); 
        
        addIconHolder.addMouseListener(new MouseAdapter() {
        	FileHandler handler = new FileHandler(table);
        	public void mouseClicked(MouseEvent e) {
        		
        		AddToUI.newItemDialogue(table);
        		handler.InventoryToFile("files/inventorydatabase.txt");
        		tableModel.setDataVector(FileHandler.InventoryFromFile("files/inventorydatabase.txt"), itemTraits);
        		tableModel.fireTableDataChanged();
        	}
        });   
        
        
        logoutButton.addActionListener(new ActionListener() {	        	
        	public void actionPerformed(ActionEvent e) {
        		
        		Login.resetFields();
        		CardLayoutController.showLogin();
        		
        	}
        });  
        
        AddUserButton.addActionListener(new ActionListener() {	
        	public void actionPerformed(ActionEvent e) {
        		
        		AccountManager.createAcc();	
        		
        	}	
        });  
        
        searchIconHolder.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		AddToUI.searchItemDialogue(1, table);
        	}
        });   
        
      
        return cardPanel;
    }
}
    

    
    
    
    
    
    
    
    
    
    
    
    
    
