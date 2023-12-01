import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;

public class FileHandler {
	
	    private static JTable table;

	    public FileHandler(JTable table) {
	        this.table = table;
	    }
	
	public static String[][] InventoryFromFile(String filePath) {
		
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
	
	
	
	public void InventoryToFile(String filepath) {
		
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (int i = 0; i < table.getRowCount(); i++) {
                bw.write(table.getValueAt(i, 0) + "," + table.getValueAt(i, 1) + "," + table.getValueAt(i, 2));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
