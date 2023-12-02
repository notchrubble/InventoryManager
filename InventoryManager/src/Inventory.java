import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Inventory {
	
	private DefaultTableModel tableModel;
	
    public JPanel homePage() {
    	
    	String[][]items = FileHandler.InventoryFromFile("files/inventorydatabase.txt");
        String[] itemTraits = { "Name", "Amount", "Other", "Edit", "Delete" };
        tableModel = new DefaultTableModel(items, itemTraits);
        
        JTable table = new JTable(tableModel) {
        	
        	public boolean isCellEditable(int row, int column) {
                return column == 4;
                
            }
        };
        
        table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());

        // Add action listener for the button
        table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField(), table));
        
        
        
        JPanel cardPanel = new JPanel();
        
    	ImageIcon icon = new ImageIcon("Art/profile.png");
    	ImageIcon addIcon = new ImageIcon("art/add.png");
    	
    	JLabel iconHolder = new JLabel(icon);
    	JLabel addIconHolder = new JLabel(addIcon);
    	
 
        JToolBar toolBar = AddToUI.createToolBar(); 
  
        JPopupMenu popupMenu = AddToUI.popMenu();
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem AddUser = new JMenuItem("Add User");

        
        popupMenu.add(logout);
        popupMenu.add(AddUser);
        toolBar.add(addIconHolder);
        toolBar.add(iconHolder);
        cardPanel.add(toolBar, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1200,640));
        
        AddToUI.addComponent(cardPanel, scrollPane, 0, 0, 0, 0, 0, 0);
        
 
        
          
        
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
        
        return cardPanel;
    }
    class ButtonRenderer extends JButton implements TableCellRenderer {
    	

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Delete");
            return this;
        }
    }
    
    
    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
      
        private int clickedRow; // Add this variable
      
        private String label;

		private JTable table;

        public ButtonEditor(JTextField textField, JTable table) {
            super(textField);
            this.table = table;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> {
            	int row = table.convertRowIndexToModel(table.getEditingRow());
            	fireEditingStopped();
         
                AddToUI.showEditDialog(row, table);
            });
            
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }
    }
    
    
    
        
        
        
    
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
