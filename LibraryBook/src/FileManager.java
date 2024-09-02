import java.util.ArrayList;
import java.io.*;
public class FileManager {
	
	private String filePath;
	private int userIDCounter;
	
	public FileManager(String filePath) {
        this.filePath = filePath;
        initializeUserIDCounter();
    }
	
	public void writeUsersToFile(ArrayList<User> userData) {
		
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            for (User user : userData) {
                writer.write(user.getUserID() + ","
                        + user.getName() + ","
                        + user.getAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void readUsersFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    System.out.printf("%30s", index);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void initializeUserIDCounter() {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int maxID = 0;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int currentID = Integer.parseInt(fields[0]); // Assume userID is the first field
                if (currentID > maxID) {
                    maxID = currentID;
                }
            }
            userIDCounter = maxID + 1; // Start from the next ID
        } catch (IOException e) {
            e.printStackTrace();
            userIDCounter = 1; // Default to 1 if the file is empty or not found
        }
	}
	
	
	
	public void writeNewBookToFile (ArrayList<Book> bookData) {
		
		try (BufferedWriter writer = new BufferedWriter (new FileWriter(filePath,true))) {
			for (Book book : bookData) {
				writer.write(book.getBookID() + ","
						+ book.getUniqueID() + ","
						+ book.getTitle() + ","
						+ book.getAuthor() + ","
						+ book.getIsIssued());
                writer.newLine();
			}
		}catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	public int getNextUserID() {
        return userIDCounter++;
    }
	
	public void clearBookFile() throws IOException {
		PrintWriter writer = new PrintWriter(filePath); 
		writer.print("");
		writer.close();
	}

}
