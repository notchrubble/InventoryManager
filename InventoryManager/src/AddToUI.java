import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.EventObject;

import java.util.function.BiConsumer;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class AddToUI {
	
	 public static void addComponent(JPanel panel, Component component, int x, int y, int top, int left, int bottom, int right) {
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = x;
	        gbc.gridy = y;
	        gbc.insets = new Insets(top, left, bottom, right);
	        panel.add(component, gbc);
	    }
	
	//Builder Method to construct a JLabel with values passed in for x and y coords -- top, left, bottom, and right padding
	public static void label(JPanel panel, String input, int x, int y, int top, int left, int bottom, int right) {
		
		JLabel labelfield = new JLabel(input);
		addComponent(panel, labelfield, x, y, top, left, bottom, right);
	}
	
	public static void imageLabel(JPanel panel, ImageIcon image, int x, int y, int top, int left, int bottom, int right) {
		
		JLabel labelfield = new JLabel(image);
		addComponent(panel, labelfield, x, y, top, left, bottom, right);
	}
	
	
	//Builder Method to construct a JTextField using same methodology as above. Returns the textfield so that it is interactable after placement
	public static JTextField userText(JPanel panel, int x, int y, int top, int left, int bottom, int right) {
		
		JTextField textfield = new JTextField(15);
		textfield.setPreferredSize(new Dimension(200, 35));
		addComponent(panel, textfield, x, y, top, left, bottom, right);
		return textfield;		
	}
	
	//Builder Method to construct a JPassword field. Returns the JPassword so that it is interactable after placement.
	public static JPasswordField userPass(JPanel panel, int x, int y, int top, int left, int bottom, int right) {
		
		JPasswordField passfield = new JPasswordField(15);
		passfield.setPreferredSize(new Dimension(200, 35));
		addComponent(panel, passfield, x, y, top, left, bottom, right);
		return passfield;
	}
	
	//Builder Method to construct a JButton field. Returns the JButton so that it is interactable after placement.
	public static JButton button(JPanel panel, String input, int x, int y, int top, int left, int bottom, int right) {
		
		JButton buttonfield = new JButton(input);
		buttonfield.setPreferredSize(new Dimension(200, 35));
		addComponent(panel, buttonfield, x, y, top, left, bottom, right);
		return buttonfield;
	}
	
	public static JPopupMenu popMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		return popupMenu;
	}
	
	public static JToolBar createToolBar() {
		JToolBar toolbar = new JToolBar();
		
	    toolbar.add(Box.createHorizontalGlue());
	    toolbar.setOrientation(JToolBar.HORIZONTAL);
		toolbar.setBackground(new Color(85,85,85));
		toolbar.setPreferredSize(new Dimension(1280, 40));     
		toolbar.setFloatable(false);
        toolbar.setBorderPainted(false);
        return toolbar;
	}
	
	public static JTable newItemDialogue(JTable table) {
		  JTextField nameField = new JTextField();
          JTextField amountField = new JTextField();
          JTextField otherField = new JTextField();
  
          Object[] message = {
              "Enter Item Name:", nameField,
              "Enter Item Amount:", amountField,
              "Enter Item Description:", otherField
          };
  
          int option = JOptionPane.showConfirmDialog(null, message, "Add New Item", JOptionPane.OK_CANCEL_OPTION);
          if (option == JOptionPane.OK_OPTION) {
        	  DefaultTableModel model = (DefaultTableModel) table.getModel();
              model.addRow(new Object[]{"",nameField.getText(), amountField.getText(), otherField.getText(), "",});
    
          }
          return table;
      }
	
	public static void showEditDialog(int row, JTable tableModel) {
        String itemName = (String) tableModel.getValueAt(row, 0);
        String itemAmount = (String) tableModel.getValueAt(row, 1);
        String itemOther = (String) tableModel.getValueAt(row, 2);

        JTextField nameField = new JTextField(itemName);
        JTextField amountField = new JTextField(itemAmount);
        JTextField otherField = new JTextField(itemOther);

        Object[] message = {
            "New Item Name:", nameField,
            "New Quantity", amountField,
            "New Description", otherField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Edit Item", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            tableModel.setValueAt(nameField.getText(), row, 0);
            tableModel.setValueAt(amountField.getText(), row, 1);
            tableModel.setValueAt(otherField.getText(), row, 2);
            FileHandler handler = new FileHandler(tableModel);
            handler.InventoryToFile("files/inventorydatabase.txt");
        }
    }

	public static void searchItemDialogue(int row, JTable tableModel) {
		
		 JTextField nameField = new JTextField();
		 
		 Object[] message = {
		            "Search for Item:", nameField,
		         
		        };
		
		 int option = JOptionPane.showConfirmDialog(null, message, "Search For Item", JOptionPane.OK_CANCEL_OPTION);
	        if (option == JOptionPane.OK_OPTION) {
	           
	        	
	        	
	        	
	        	
	        	
	        }
	    }
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.AbstractCellEditor;
import javax.swing.event.CellEditorListener;

public class AddToUI {
    
    private static void addComponent(JPanel panel, Component component, int x, int y, int top, int left, int bottom, int right) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(top, left, bottom, right);
        panel.add(component, gbc);
    }

    public static void label(JPanel panel, String input, int x, int y, int top, int left, int bottom, int right) {
        JLabel labelfield = new JLabel(input);
        addComponent(panel, labelfield, x, y, top, left, bottom, right);
    }

    public static void imageLabel(JPanel panel, ImageIcon image, int x, int y, int top, int left, int bottom, int right) {
        JLabel labelfield = new JLabel(image);
        addComponent(panel, labelfield, x, y, top, left, bottom, right);
    }

    public static JTextField userText(JPanel panel, int x, int y, int top, int left, int bottom, int right) {
        JTextField textfield = new JTextField(15);
        textfield.setPreferredSize(new Dimension(200, 35));
        addComponent(panel, textfield, x, y, top, left, bottom, right);
        return textfield;
    }

    public static JPasswordField userPass(JPanel panel, int x, int y, int top, int left, int bottom, int right) {
        JPasswordField passfield = new JPasswordField(15);
        passfield.setPreferredSize(new Dimension(200, 35));
        addComponent(panel, passfield, x, y, top, left, bottom, right);
        return passfield;
    }

    public static JButton button(JPanel panel, String input, int x, int y, int top, int left, int bottom, int right) {
        JButton buttonfield = new JButton(input);
        buttonfield.setPreferredSize(new Dimension(200, 35));
        addComponent(panel, buttonfield, x, y, top, left, bottom, right);
        return buttonfield;
    }

    public static JPopupMenu popMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        return popupMenu;
    }

    public static JToolBar createToolBar() {
        JToolBar toolbar = new JToolBar();
        toolbar.add(Box.createHorizontalGlue());
        toolbar.setOrientation(JToolBar.HORIZONTAL);
        toolbar.setBackground(Color.gray);
        toolbar.setPreferredSize(new Dimension(1280, 40));
        toolbar.setFloatable(false);
        toolbar.setBorderPainted(false);
        return toolbar;
    }

    public static JTable createTable(JPanel panel, String[] columnNames, Object[][] data, int x, int y, int top, int left, int bottom, int right) {
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1200, 640));
        addComponent(panel, scrollPane, x, y, top, left, bottom, right);
        return table;
    }

    public static void addButtonToTable(JTable table, int column, String buttonText, BiConsumer<JTable, Integer> action) {
        table.getColumnModel().getColumn(column).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton button = new JButton(buttonText);
                button.addActionListener(e -> action.accept(table, row));
                return button;
            }
        });

        table.getColumnModel().getColumn(column).setCellEditor(new ButtonEditor(buttonText, action));
    }

    static class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
        private final JButton button;
        private final BiConsumer<JTable, Integer> action;

        public ButtonEditor(String buttonText, BiConsumer<JTable, Integer> action) {
            this.button = new JButton(buttonText);
            this.action = action;
            button.addActionListener(e -> {
                action.accept((JTable) button.getParent(), (Integer) button.getClientProperty("row"));
                stopCellEditing(); // Stop editing after button press
            });
        }
        

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.putClientProperty("row", row);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean stopCellEditing() {
            fireEditingStopped(); // Notify the table that editing has stopped
            return true;
        }

        @Override
        public void cancelCellEditing() {
            fireEditingCanceled(); // Notify the table that editing has been canceled
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
            listenerList.add(CellEditorListener.class, l);
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
            listenerList.remove(CellEditorListener.class, l);
        }
    }
}
	
