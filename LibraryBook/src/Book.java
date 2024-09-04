
public class Book {
	
	private int bookID;
	private int uniqueID;
	private String title;
	private String author;
	private boolean isIssued;
	
	public Book( int bookID, int uniqueID, String title, String author ) {
		this.bookID = bookID;
		this.uniqueID = uniqueID;
		this.title = title;
		this.author = author;
		this.isIssued = false;
	}
	
	public int getBookID() {
		return bookID;
	}
	
	public void setBookID(int newID) {
		this.bookID = newID;
	}
	
	public int getUniqueID() {
		return uniqueID;
	}
	
	public void setUniqueID(int inID) {
		this.uniqueID = inID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public boolean getIsIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }
	
	
	public String toString() {
        return bookID + "," + uniqueID + "," + title + "," + author + "," + isIssued;
    }
	
	public void IssueBook() {
		
	
	}
	
	
	
}
