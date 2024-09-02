
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Library {
	
	Scanner input = new Scanner(System.in);
	private static int userIDCounter = 1;
	ArrayList<User> userData = new ArrayList<>();
	
	public void addNewBook() {
		String name;
		boolean isIssued = false;
//		User newUser = new User();
		System.out.print("Enter a name: ");
		name = input.next();
		
		
		System.out.print(userData.get(1));
	}
	
	private void removeBook(/*Book*/) {
		
	}
	
	public void addUser(/*User*/) {
		
		
		System.out.print("Enter new user's name: ");
		String inputName = input.next();
		
		
		System.out.print("Enter new user's address: ");
		String inputAddress = input.next();
		
		writeUsersToFile(inputName,inputAddress);
		

	
	}
	private void issueBook(/*bookID, userID*/) {
		
		
	}
	
	private void returnBook(/*bookID, userID*/) {
		
	}
	
	private void displayBooks() {
		
	}
	
	public void displayUsers() {
		readUsersFile();
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
	
	private void writeUsersToFile(String inName,String inAddress) {
		
		
		User newUser = new User(userIDCounter++,inName,inAddress);
		
        
		String file = "C:\\Users\\rahul\\git\\repository\\LibraryBook\\src\\Users.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        	
            userData.add(newUser);
            for (User user : userData) {
            	writer.write(user.getUserID() + ","
                        + user.getName() + ","
                        + user.getAddress());
                writer.newLine();
            }
            
        }catch (IOException e) {
        	e.printStackTrace();
        }
		
	}
	
}
