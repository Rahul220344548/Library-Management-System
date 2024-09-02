import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
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
}
