
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
		String inputName = input.nextLine();
		
		
		System.out.print("Enter new user's address: ");
		String inputAddress = input.nextLine();
		
		if (isValidAddress(inputAddress)) {
            System.out.println("The string is a valid address.");
        } else {
            System.out.println("The string is not a valid address.");
        }
		
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
            
        	writer.write(newUser.getUserID() + ","
                    + newUser.getName() + ","
                    + newUser.getAddress());
        	writer.newLine();
        	
        }catch (IOException e) {
        	e.printStackTrace();
        }
		
	}
	
	public static boolean isValidAddress(String input) {
        // This is a basic example; real-world addresses can be much more complex.
        String regex = "\\d+\\s+([A-Za-z]+\\s?)+\\s*(Street|St|Avenue|Ave|Boulevard|Blvd|Road|Rd|Lane|Ln|Drive|Dr|Court|Ct|Place|Pl)?";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
