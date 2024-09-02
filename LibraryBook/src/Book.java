
public class Book {
	
	private int bookID;
	private String title;
	private String author;
	private boolean isIssued;
	
	public Book( int bookID, String title, String author ) {
		this.bookID = bookID;
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
	
	
	
}
