import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	private String getCurrentDate() {
		LocalDateTime currentDateTime = LocalDateTime.now();
        // Define the formatter for dd/MM/yyyy HH:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        
        return formattedDateTime;
	}
	
	public static boolean isValidAddress(String input) {
        // This is a basic example; real-world addresses can be much more complex.
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
		if (input.matches("\\d{4,5}")) {
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
}
