import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class issueBookManager {
	
	private String filePath;
	
	public issueBookManager(String filePath) {
        this.filePath = filePath;
    }
	
	public void readBooksToArray() {
		
		List<String[]> bookRecords = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			
			String line;
			while ((line = reader.readLine()) != null ) {
				String[] bookRecord = line.split(",");
				bookRecords.add(bookRecord);
			}
			
		}catch (IOException e){
			e.printStackTrace();
		}
		Utility.displayBookRecords(bookRecords);
	}
	
	public void readUsersToArray() {
		
		List<String[]> userRecords = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null ) {
				String[] userRecord = line.split(",");
				userRecords.add(userRecord);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		Utility.displayUserRecords(userRecords);
		
	}
		
		
}
