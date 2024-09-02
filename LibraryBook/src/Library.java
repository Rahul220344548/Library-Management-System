
import java.util.ArrayList;
import java.util.Scanner;

import java.io.*;


public class Library {
	
	Scanner input = new Scanner(System.in);
	private static int userIDCounter = 1;
	ArrayList<User> userData = new ArrayList<>();
	FileManager userFileManager = new FileManager("C:\\Users\\rahul\\git\\repository\\LibraryBook\\src\\Users.csv");
	
	
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
		
		if (Utility.isValidAddress(inputAddress)) {
            System.out.println("The string is a valid address.");
        } else {
            System.out.println("The string is not a valid address.");
        }
		
		User newUser = new User(userIDCounter++, inputName, inputAddress);
        userData.add(newUser);
        userFileManager.writeUsersToFile(userData);
	
	}
	private void issueBook(/*bookID, userID*/) {
		
		
	}
	
	private void returnBook(/*bookID, userID*/) {
		
	}
	
	private void displayBooks() {
		
	}
	
	public void displayUsers() {
		userFileManager.readUsersFile();
	}
	
	
	
	
	
	

}
