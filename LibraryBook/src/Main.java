import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	
	
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
			
		}while (userOption!=7);
		System.out.println("Exiting... Goodbye!");
		input.close();
	}
	
	private void displayMenu() {
		
		System.out.println("========== Select an Option: ==========");
		
		System.out.println("  1. Add a new book");
		System.out.println("  2. Add a new user");
		System.out.println("  3. Issue a book to a user");
		System.out.println("  4. Return a book");
		System.out.println("  5. Display all books");
		System.out.println("  6. Display all users");
		System.out.println("  7. Save & Exit");
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
                if (option < 1 || option > 7) {
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
    	
    	 switch (userOption) {
    	 	case 1:
    	 		System.out.println("Add a new book");
    	 		break;	
    	 	case 2:
    	 		System.out.println("Add a new user");
    	 		break;
    	 	case 3:
    	 		System.out.println("Issue a book to a user");
    	 		break;
    	 	case 4:
    	 		System.out.println("Return a book");
    	 		break;
    	 	case 5:
    	 		System.out.println("Display all books");
    	 		break;
    	 	case 6:
    	 		System.out.println("Display all users");
    	 		break;
    	 	case 7:
    	 		System.out.println("EXIT...");
    	 		break;
    	 	 default:  
                 System.out.println("Invalid choice. Please try again."); 
    	 }
    }

}
