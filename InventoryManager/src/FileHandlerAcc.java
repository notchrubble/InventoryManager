import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileHandlerAcc {
	 public static void readUserAccounts(String filePath) {

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] userData = line.split(":");
	                AccountManager.user_accs.put(userData[0], userData[1]); // Assuming username is in index 0 and password in index 1
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	   

	    // Write user accounts to file
	    public static void writeUserAccounts(String filePath) {
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
	            for (Map.Entry<String, String> entry : AccountManager.user_accs.entrySet()) {
	                bw.write(entry.getKey() + ":" + entry.getValue());
	                bw.newLine();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    

}
