
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import java.io.*;


public class Library {
	
	Scanner input = new Scanner(System.in);
	ArrayList<User> userData = new ArrayList<>();
	ArrayList<Book> bookData = new ArrayList<>();
	FileManager userFileManager = new FileManager("C:\\Users\\rahul\\git\\repository\\LibraryBook\\src\\Users.csv");
	FileManager bookFileManager = new FileManager("C:\\Users\\rahul\\git\\repository\\LibraryBook\\src\\Books.csv");

	
	public void addNewBook() {
		Utility generate = new Utility();
		int uniqueID = generate.generateFourDigitNumber();
		
		String bookTitle;
		String bookAuthor;
		
		System.out.print("Enter Book's Title:  ");
		bookTitle = input.nextLine();
		
		System.out.print("Enter Book's Author:  ");
		bookAuthor = input.nextLine();
		
		Book newBook = new Book(bookFileManager.getNextUserID(),uniqueID,bookTitle,bookAuthor);
		bookData.add(newBook);
		bookFileManager.writeNewBookToFile(bookData);
		
	}
	
	public void removeBook(/*Book*/) {
		System.out.println("-----Removes Element------");
		
		String searchTerm = "1953";
		
//		String searchTerm;
//		System.out.print("Enter ISBN number of Book to remove:  ");
//		searchTerm = input.nextLine();
		
		//Reads data into record 
		bookFileManager.readRecord(searchTerm);
		
		

	}
	
	public void addUser(/*User*/) {
		
		
		boolean isValid = false;
		String inputAddress = null;
		

		System.out.print("Enter new user's name: ");
		String inputName = input.nextLine();
	
		while (!isValid) {
			System.out.print("Enter new user's address: ");
            inputAddress = input.nextLine();
			
            if (Utility.isValidAddress(inputAddress)) {
                System.out.println("The string is a valid address.");
                isValid = true; // Address is valid, exit the loop
            } else {
                System.out.println("The string is not a valid address. Please try again.");
            }
		}
		User newUser = new User(userFileManager.getNextUserID(), inputName, inputAddress);
        userData.add(newUser);
        userFileManager.writeUsersToFile(userData);
	
	}
	private void issueBook(/*bookID, userID*/) {
		
		
	}
	
	private void returnBook(/*bookID, userID*/) {
		
	}
	
	public void displayBooks() {
		bookFileManager.readUsersFile();
	}
	
	public void displayUsers() {
		userFileManager.readUsersFile();
	}
	
	void clearBookFile() {
		try {
			bookFileManager.clearBookFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void clearUserFile() {
		try {
			userFileManager.clearBookFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
