import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int userID;
	private String name;
	private String address;
	private boolean isIssued;
	private List<Book> checkedOutBooks;
	
	public User(int userID, String name,String address) {
		this.userID = userID;
		this.name = name;
		this.address = address;
		this.isIssued = false;
		this.checkedOutBooks = new ArrayList<>();
	}
	
	public int getUserID() {
		return userID;
	}
	
	void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
	
	public boolean getisIssued() {
		return isIssued;
	}
	
	void setIsIssued(boolean isIssued) {
		this.isIssued = false;
	}
	
	public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }
	
	public void checkOutBook(Book book) {
        checkedOutBooks.add(book);
        setIsIssued(true); // Update the isIssued flag
    }
	
	public void returnBook(Book book) {
        checkedOutBooks.remove(book);
        if (checkedOutBooks.isEmpty()) {
            setIsIssued(false); // Update the isIssued flag
        }
    }

	
}
