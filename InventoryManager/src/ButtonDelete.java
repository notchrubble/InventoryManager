import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ButtonDelete extends DefaultCellEditor {

	protected JButton button;
	private String label;
	private JTable table;
	
	public ButtonDelete(JTextField textfield, JTable table) {
		super(textfield);
		this.table = table;
		button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> {
            int row = table.convertRowIndexToModel(table.getEditingRow());
            fireEditingStopped();
            AddToUI.showDeleteDialog(row, table);
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