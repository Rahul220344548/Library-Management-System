import java.util.HashMap;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
	Scanner input = new Scanner(System.in);
	Map<Integer, Book> bookData = new HashMap<>();
	Map<Integer, User> userData = new HashMap<>();
	
	
	public static void main(String[] args) {
		
		Main main = new Main();
		main.run();
		
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int userOption;
		do {
			displayMenu();
			userOption = getUserOption(input);
			handleUserOption(userOption);
			
		}while (userOption!=8);
		System.out.println("Exiting... Goodbye!");
		input.close();
	}
	
	private void displayMenu() {
		
		System.out.println("========== Select an Option: ==========");
		
		System.out.println("  1. Add a new book");
		System.out.println("  2. Add a new user");
		System.out.println("  3. remove a book");
		System.out.println("  4. Issue a book to a user");
		System.out.println("  5. Return a book");
		System.out.println("  6. Display all books");
		System.out.println("  7. Display all users");
		System.out.println("  8. Save & Exit");
		System.out.println("=======================================");  
		System.out.print("Enter: ");
		
	}
	
	
    private int getUserOption(Scanner input) {
    	// add checks here for check if options are > 7 or < 1 
    	boolean validInput = false;
    	int option = -1;
    	while (!validInput) {
            try {
                option = input.nextInt();
                if (option < 1 || option > 8) {
                    System.out.println("Invalid option. Please enter a number between 1 and 7.");
                    System.out.print("Enter: ");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Enter: ");
                input.next(); // Clear the invalid input
            }
        }
        return option;	
    }

    public void handleUserOption(int userOption) {
    	Library myLib = new Library();
    	 switch (userOption) {
    	 	case 1:
    	 		myLib.addNewBook();
//    	 		System.out.println("Add a new book");
    	 		break;	
    	 	case 2:
    	 		
    	 		myLib.addUser();
    	 		break;
    	 	case 3: 
    	 		myLib.removeBook();
    	 		break;
    	 	case 4:
    	 		System.out.println("Issue a book to a user");
    	 		myLib.issueBook(7,1);
    	 		break;
    	 	case 5:
//    	 		myLib.clearUserFile();
    	 		System.out.println("Return a book");
    	 		break;
    	 	case 6:
    	 		myLib.displayBooks();
    	 		break;
    	 	case 7:
    	 		myLib.displayUsers();
//    	 		System.out.println("Display all users");
    	 		break;
    	 	case 8:
    	 		System.out.println("EXIT...");
    	 		break;
    	 	 default:  
                 System.out.println("Invalid choice. Please try again."); 
    	 }
    }

}
