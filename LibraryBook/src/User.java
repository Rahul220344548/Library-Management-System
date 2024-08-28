
public class User {
	
	private int userID;
	private String name;
	private boolean isIssued;
	
	public User(int userID, String name,boolean isIssued) {
		this.userID = userID;
		this.name = name;
		this.isIssued = isIssued;
	}
	
	public int getUserID() {
		return userID;
	}
	public String getName() {
		return name;
	}
	public boolean checkisIssued() {
		return isIssued;
	}
	
}
