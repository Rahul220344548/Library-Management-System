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
	
	public int setBookStatus(int bookElement) {
		// This should update the book element 2 to True
		// update user issued to True
		// add the book to users checkout books
		// stored it in file 
		
		// Read File into records
		
		List<String[]> Books = readBooksToArray();
		
		
		System.out.println("   ####"+Arrays.toString(Books.get(bookElement))+"#####   ");
		
		String[] bookDetails = Books.get(bookElement);
		String getBookStatus = bookDetails[4];
		boolean isBookAvailable = Boolean.parseBoolean(getBookStatus);
		
		if (!isBookAvailable) {
			System.out.println("Current Status: "+ getBookStatus);
			
			bookDetails[4] = String.valueOf(true);
			Books.set(bookElement, bookDetails);
			
			System.out.println("Updated Status: " + Arrays.toString(Books.get(bookElement)));
			writeUpdatedStatusToFile(Books);
			return 1;
			
		}else {
			return -1;
//			System.out.println("Current Status of book is already "+getBookStatus);

		}
		// need to push this book into users file record , and update users status
		
		
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

		String[] userDetails = Users.get(userElement);
		String getUserStatus = userDetails[3];

		boolean isUserStatusTrue = Boolean.parseBoolean(getUserStatus);
		
		if (!isUserStatusTrue) {
			
			System.out.println("Current Status: "+ isUserStatusTrue);
			
			userDetails[3] = String.valueOf(true);
			Users.set(userElement, userDetails);
			
			System.out.println("Updated Status: " + Arrays.toString(Users.get(userElement)));
			
			writeUpdatedStatusToFile(Users);
		
			
		}else {
			
			System.out.println("Current Status of User is already "+ getUserStatus);
		}
				
		
	}

	public void updateUserCheckoutRecords(int userElement,String nameToAddToArray) {
		
		// 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
		
		

		List<String[]> users = readUsersToArray();
		
		String existingBooksString = users.get(userElement)[4];
		
		String[] existingBooksArray = existingBooksString.split(":");
		ArrayList<String> existingBooks = new ArrayList<>(Arrays.asList(existingBooksArray));
	    	
		if (existingBooksString.length() == 2) { 
			
			existingBooks.clear();
			
			existingBooks.add(nameToAddToArray);
			String bookString = String.join(":",existingBooks);
			
			users.get(userElement)[4] = bookString;
			
			writeUpdatedStatusToFile(users);
			
		}else {
			
			existingBooks.add(nameToAddToArray);
			String bookString = String.join(":",existingBooks);
			
			users.get(userElement)[4] = bookString;
			
			writeUpdatedStatusToFile(users);
			
		}
			
//		for (String i : existingBooksArray) {
//			System.out.print(i + ", ");
//		}
//		System.out.println();
		
		
	}
	
}
