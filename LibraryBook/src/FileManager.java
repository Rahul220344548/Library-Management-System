import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                        + user.getAddress() + ","
                        + user.getisIssued() + ","
                        + user.getCheckedOutBooks());
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
                    System.out.printf("%20s", index);
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
                int currentID = Integer.parseInt(fields[0]); 
                if (currentID > maxID) {
                    maxID = currentID;
                }
            }
            userIDCounter = maxID + 1; 
        } catch (IOException e) {
            e.printStackTrace();
            userIDCounter = 1; 
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
	
	public void readRecord(String searchTerm) {
		
		List<String[]> bookRecords = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			
			String line;
			while ((line = reader.readLine()) != null ) {
				String[] bookRecord = line.split(",");
				bookRecords.add(bookRecord);
			}
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
		int removeElementAt = Utility.searchISBNnumber(bookRecords, searchTerm);
		if (removeElementAt == -1) {
			System.out.println("ERROR! ISBN number not found.");
		}else {
			
			System.out.println("   ####"+Arrays.toString(bookRecords.get(removeElementAt))+"#####   ");
			
			if (Utility.confirmRemoveBook()==1) {
				bookRecords.remove(removeElementAt);
				removeRecord(bookRecords);
				System.out.println("Book removed Successully!");
			}else {
				System.out.println("No changes made.");
			}
		}
	}

	public void removeRecord(List<String[]> bookRecords ) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] record : bookRecords) {
                writer.write(String.join(",", record));
                writer.newLine();
            }
        } catch (IOException e) {
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
