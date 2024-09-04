import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class issueBookManager {
	
	private String filePath;
	
	public issueBookManager(String filePath) {
        this.filePath = filePath;
    }
	
	public List<String[]> readBooksToArray() {
		
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
		return bookRecords;
//		Utility.displayBookRecords(bookRecords);
	}
	
	public List<String[]> readUsersToArray() {
		
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
		return userRecords;
		
	}

	
	public static int searchBookID(List<String[]> bookRecords,String searchTerm) {
		
		int element;
		for (int i = 0; i < bookRecords.size(); i++) {
			if (bookRecords.get(i)[0].toString().equals(searchTerm)) {
				element = i;
				return element;
			}
		}
		return -1;
	}	
	
	public void setBookStatus(int bookElement) {
		// This should update the book element 2 to True
		// update user issued to True
		// add the book to users checkout books
		// stored it in file 
		
		// Read File into records
		
		List<String[]> Books = readBooksToArray();

		
		System.out.println("   ####"+Arrays.toString(Books.get(bookElement))+"#####   ");
		
		String[] bookDetails = Books.get(bookElement);
		String getBookStatus = bookDetails[4];
		
		System.out.println("Current Status: "+ getBookStatus);
		
		bookDetails[4] = "TRUE";
		
		Books.set(bookElement, bookDetails);
		
		System.out.println("Updated Status: " + Arrays.toString(Books.get(bookElement)));
		
		// write this data to file 
		writeUpdatedStatusToFile(Books);
		
		
	}
	
	public void writeUpdatedStatusToFile(List<String[]> books) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] book : books) {
                // Write each book's details as a comma-separated string
                writer.write(String.join(",", book));
                writer.newLine();  // Move to the next line for each book
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void setUserStatus(int userElement) {
		
		List<String[]> Users = readUsersToArray();
		
		System.out.println("   ####"+Arrays.toString(Users.get(userElement))+"#####   ");
		
		String updateUserStatus = Users.get(userElement)[3];
		
		System.out.println(updateUserStatus);
		
		
	}
	
}
