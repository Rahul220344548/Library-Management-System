
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Library {
	
	Scanner input = new Scanner(System.in);
	Map<Integer, Book> bookData = new HashMap<>();
	Map<Integer, User> userData = new HashMap<>();
	private static int userIDCounter = 1;
	
	public Library() {
        userData = new HashMap<>();
    }
	
	
	public void addNewBook() {
		String name;
		boolean isIssued = false;
//		User newUser = new User();
		System.out.print("Enter a name: ");
		name = input.next();
		userData.put(1, new User(1,name,false));
		
		System.out.print(userData.get(1));
	}
	
	private void removeBook(/*Book*/) {
		
	}
	
	public void addUser(/*User*/) {
		
        System.out.print("Enter name: ");
        String name = input.next();
        
        System.out.println("Enter address: ");
        String address = input.next();
        
        
        
//		userData.put(1, new User(1,"Rahul",false));
//
//		readUsersFile();
	
	}
	private void issueBook(/*bookID, userID*/) {
		
		
	}
	
	private void returnBook(/*bookID, userID*/) {
		
	}
	
	private void displayBooks() {
		
	}
	
	private void displayUsers() {
		
	}
	
	private void readUsersFile() {
		String file = "C:\\Users\\rahul\\git\\repository\\LibraryBook\\src\\Users.csv";
		BufferedReader reader = null;
		String line = "";
		
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null ) {
				String [] row = line.split(",");
				
				for ( String index : row ) {
					System.out.printf("%30s", index);
				}
				System.out.println();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private String getCurrentDate() {
		LocalDateTime currentDateTime = LocalDateTime.now();
        // Define the formatter for dd/MM/yyyy HH:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        
        return formattedDateTime;
	}
}
