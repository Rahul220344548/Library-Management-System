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
			
		}while (userOption!=7);
		System.out.println("Exiting... Goodbye!");
		input.close();
	}
	
	private void displayMenu() {
		System.out.println("Select an Option: ");
		System.out.println("  1. Add a new book");
		System.out.println("  2. Add a new user");
		System.out.println("  3. Issue a book to a user");
		System.out.println("  4. Return a book");
		System.out.println("  5. Display all books");
		System.out.println("  6. Display all users");
		System.out.println("  7. Save & Exit");
		System.out.println();
		System.out.print("Enter: ");
	}
	
	
    private int getUserOption(Scanner input) {
    	// add checks here for check if options are > 7 or < 1 
    	int option;
    	option = input.nextInt();
    	return option;	
    }


}
