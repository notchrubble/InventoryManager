import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import javax.swing.JTable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Random;



public class FileHandler {
	
		static String counter = "0";
		static int counterInt;
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
	                String shipmentDate = itemData[4];
	                itemList.add(new String[] { itemData[0], itemData[1], itemData[2],itemData[3] , shipmentDate });
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return itemList.toArray(new String[0][]);
	    }

	    
	    
	
	    public void InventoryToFile(String filepath) {
	    	
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-YY");
	    	Random random = new Random();
	    	int year = 2024;
	    	int daysInYear = 365;
	    	
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
	        	
	            int counterInt = 1;  // Start the counter from 1
	           
	            for (int i = 0; i < table.getRowCount(); i++) {
	            	int randomDays = random.nextInt(daysInYear);
	    	    	LocalDate start = LocalDate.of(year, Month.JANUARY, 1);
	            	LocalDate randomDate = start.plusDays(randomDays);
	            	
	            	String rawText = table.getValueAt(i, 1).toString();
	            	rawText = rawText.toUpperCase();
	            	
	                bw.write(rawText.substring(0, 3) + counterInt + "," + table.getValueAt(i, 1) + "," + table.getValueAt(i, 2) + "," + table.getValueAt(i, 3) + "," + randomDate.format(formatter));
	                bw.newLine();
	                counterInt++;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	  }
}
