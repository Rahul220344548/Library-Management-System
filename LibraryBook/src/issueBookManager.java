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
		}	
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
	
	public int setUserStatus(int userElement) {
		
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
			return 1;
			
		}else {
			
			System.out.println("Current Status of User is already "+ getUserStatus);
			return -1;
		}
				
		
	}

	public void updateUserCheckoutRecords(int userElement,String nameToAddToArray) {
		

		List<String[]> users = readUsersToArray();
		
		String existingBooksString = users.get(userElement)[4];
		
		String[] existingBooksArray = existingBooksString.split(":");
		ArrayList<String> existingBooks = new ArrayList<>(Arrays.asList(existingBooksArray));
	    
		if (existingBooks.size()>=5) {
			System.out.println("User has reached or exceeded the maximum book limit.");
			return;
		}
		
		if (existingBooksString.length() == 2) { 
			existingBooks.clear();	
		}

		existingBooks.add(nameToAddToArray);
		
		String bookString = String.join(":",existingBooks);
		
		users.get(userElement)[4] = bookString;
		
		writeUpdatedStatusToFile(users);
		
		System.out.println("Book added Successfully!");	
		
	}
	
	public int updateBookStatus(int bookElement) {
		
		List<String[]> Books = readBooksToArray();
		
		System.out.println("   ####"+Arrays.toString(Books.get(bookElement))+"#####   ");
		
		String[] bookDetails = Books.get(bookElement);
		String getBookStatus = bookDetails[4];
		boolean isBookSetToTrue = Boolean.parseBoolean(getBookStatus);
		
		if (!isBookSetToTrue) {
			return -1;
		}
		bookDetails[4] = String.valueOf(false);
		Books.set(bookElement, bookDetails);
		System.out.println("Updated Status: " + Arrays.toString(Books.get(bookElement)));
		return 1;
		
	}
	
	public void removeBookFromUserRecords (int userElement, String bookName) {
		
		List<String[]> users = readUsersToArray();
		
		String existingBooksString = users.get(userElement)[4];
		
		String[] existingBooksArray = existingBooksString.split(":");
		ArrayList<String> existingBooks = new ArrayList<>(Arrays.asList(existingBooksArray));
		
		
		// need to Search for the book
	
		System.out.println(existingBooks.indexOf(bookName));
		int removeBookIndex = existingBooks.indexOf(bookName);
		
		existingBooks.remove(removeBookIndex);
		
		for (String i : existingBooks) {
			System.out.print(i+": ");
		}
		System.out.println();
		
	}
}
