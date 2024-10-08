
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import java.io.*;


public class Library {
	
	Scanner input = new Scanner(System.in);
	ArrayList<User> userData = new ArrayList<>();
	ArrayList<Book> bookData = new ArrayList<>();
	FileManager userFileManager = new FileManager("C:\\Users\\rahul\\git\\repository\\LibraryBook\\src\\Users.csv");
	FileManager bookFileManager = new FileManager("C:\\Users\\rahul\\git\\repository\\LibraryBook\\src\\Books.csv");
	issueBookManager bookIssueManager = new issueBookManager("C:\\Users\\rahul\\git\\repository\\LibraryBook\\src\\Books.csv");
	issueBookManager userIssueManager = new issueBookManager("C:\\Users\\rahul\\git\\repository\\LibraryBook\\src\\Users.csv");
	
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
		String searchTerm;
		System.out.println("Enter ISBN number of Book to remove");
		while (true) {
			System.out.print("Enter: ");
			searchTerm = input.nextLine();
			if (Utility.isValidISBN(searchTerm)) {
                break; 
            } else {
                System.out.println("Invalid input. Please enter a number with 4 or 5 digits.");
            }
		}
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
	
	
	public void issueBook(String bookID, String userID) {
				
		/**
		 * Issues a book to a user.
		 * 
		 * Checks if the book and user exist. If the book is available, it updates the book's status to issued
		 * and adds the book to the user's checkout records. If the book is already issued, it displays an error message.
		*/
		
		int[] elements = findBookAndUser(bookID, userID);
		if (elements == null) return;
		int bookElement = elements[0];
		int userElement = elements[1];

		boolean isBookAvaliable = bookIssueManager.getBookStatus(bookElement);
		

		if (!isBookAvaliable) { 
			bookIssueManager.setBookStatus(bookElement);
			
			boolean isUserStatusTrue = userIssueManager.getUserStatus(userElement);
            String nameToAddToArray = bookIssueManager.readBooksToArray().get(bookElement)[2];
		
			if (isUserStatusTrue) {
				userIssueManager.updateUserCheckoutRecords(userElement,nameToAddToArray);
				return;
			}
			userIssueManager.setUserStatus(userElement);
			userIssueManager.updateUserCheckoutRecords(userElement,nameToAddToArray);
			return;
		}
		System.out.println("The book is currently issued.");
		
	}
	
	public void returnBook(String bookID, String userID) {
		
		int[] elements = findBookAndUser(bookID, userID);
        if (elements == null) return; 

        int bookElement = elements[0];
        int userElement = elements[1];
		
		Boolean isBookStatusTrue = bookIssueManager.getBookStatus(bookElement);
		
		if (isBookStatusTrue) { 
			
			Boolean hasUserBorrowedBooks = userIssueManager.getUserStatus(userElement);
			
			if (hasUserBorrowedBooks) {

				String bookName = bookIssueManager.readBooksToArray().get(bookElement)[2];
				bookIssueManager.updateBookStatus(bookElement);
				userIssueManager.removeBookFromUserRecords(userElement, bookName);
				
				System.out.println("Book removed Successfully!");
				
				return;
			}
			System.out.println("User has not borrowed Books");
		}
		System.out.println("Book is not issued to User!");

		
		
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
	
	public void clearUserFile() {
		try {
			userFileManager.clearBookFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int[] findBookAndUser(String bookID, String userID) {
		
		List<String[]> getBookElement = bookIssueManager.readBooksToArray();
        int bookElement = bookIssueManager.searchBookID(getBookElement, bookID);

        List<String[]> getUserElement = userIssueManager.readUsersToArray();
        int userElement = userIssueManager.searchBookID(getUserElement, userID);

        if (bookElement == -1 || userElement == -1) {
            System.out.println("Error: The Book ID or User ID you entered could not be found.");
            return null; 
        }

        return new int[]{bookElement, userElement};
	}
	
	
	

}
