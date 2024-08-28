import java.util.HashMap;
import java.util.Map;

public class Library {
	
	Map<Integer, User> bookData = new HashMap<>();
//	Map<Integer, Student> userData = new HashMap<>();
	
	
	private void addNewBook() {
		bookData.put(1, new User(1,"Rahul",false));
	}
	
	private void removeBook(/*Book*/) {
		
	}
	
	private void addUser(/*User*/) {
		
	}
	private void issueBook(/*bookID, userID*/) {
		
		
	}
	
	private void returnBook(/*bookID, userID*/) {
		
	}
	
	private void displayBooks() {
		
	}
	
	private void displayUsers() {
		
	}
}
