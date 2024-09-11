
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	
	public static boolean isValidAddress(String input) {
        String regex = "\\d+\\s+([A-Za-z]+\\s?)+\\s*(Street|St|Avenue|Ave|Boulevard|Blvd|Road|Rd|Lane|Ln|Drive|Dr|Court|Ct|Place|Pl)?";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
	
	public static int generateFourDigitNumber() {
        Random random = new Random();
        // Generate a number between 1000 and 9999
        int min = 1000;
        int max = 9999;
        return random.nextInt(max - min + 1) + min;
    }
	
	public static void checkISBNnumber(Scanner input) {
		int firstCheck;
		int secondCheck;
		
		System.out.println("----REMOVE BOOK-----");
		do {
			System.out.print("Enter ISBN number of book to remove: ");
			firstCheck = input.nextInt();
			System.out.print("Confirm ISBN number: ");
			secondCheck = input.nextInt();
		}while (firstCheck != secondCheck);
		System.out.println("Removed Successfully!");
		
	}
	
	public static void displayBookRecords( List<String[]> bookRecords ) {
		for (String[] record : bookRecords) {
            System.out.println("ID : " + record[0]+" Unique ID: " + record[1] + " Title: " + record[2] + " Author: " + record[3]);
        }
	}
	
	public static void displayUserRecords (List<String[]> userRecords) {
		for (String[] record : userRecords) {
            System.out.println("ID : " + record[0]+" Name: " + record[1] + " Address: " + record[2] 
            						+ " isIssued: "+ record[3] + " booksCheckout: " + record[4]);
        }
	}
	public static int searchISBNnumber(List<String[]> bookRecords,String searchTerm) {
		
		int element;
		for (int i = 0; i < bookRecords.size(); i++) {
			if (bookRecords.get(i)[1].toString().equals(searchTerm)) {
				element = i;
				return element;
			}
		}
		return -1;
	}
	
	public static int confirmRemoveBook() {
		Scanner input = new Scanner(System.in);
		
		String userInput;
		
		System.out.println("Are you sure you want to removed this book? y/n");
		
		while (true) {
			System.out.print("Enter (y/n) : ");
			userInput = input.next();
			
			 if (userInput.equalsIgnoreCase("y")) {
				 return 1;
			 }else if (userInput.equalsIgnoreCase("n")) {
				 return -1;
			 }else {
				 System.out.println("Invalid input. Please enter 'y' or 'n'.");
			 }
		}
		
		
	}
	
	public static boolean isValidISBN(String input) {
		if (input.matches("\\d{4}")) {
            try {
                // Attempt to parse the number to ensure it is numeric
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                // Input is not a valid number
                return false;
            }
        }
        return false;
	}

	public static  ArrayList<String> storeBookNameToArray(ArrayList<String> books, String name) {
	
		books.add(name);
		
		return books;
	}
	
	public static String checkBookID(Scanner input) {
		
		String bookIDInput;
        
        while (true) {
            System.out.print("Enter book ID to issue (must be an integer): ");
            bookIDInput = input.next();
            
            if (isInteger(bookIDInput)) {
                break;  // Exit the loop if a valid integer is provided
            } else {
                System.out.println("Invalid input. Please enter a valid integer for the book ID.");
            }
        }
        return bookIDInput;
		
	}
	
	public static String checkUserID(Scanner input) {
		String userIDInput;
		
		while (true) {
            System.out.print("Enter user ID to issue book (must be an integer): ");
            userIDInput = input.next();
            
            if (isInteger(userIDInput)) {
                break;  // Exit the loop if a valid integer is provided
            } else {
                System.out.println("Invalid input. Please enter a valid integer for the user ID.");
            }
        }
		return userIDInput;
	}
	private static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
}
