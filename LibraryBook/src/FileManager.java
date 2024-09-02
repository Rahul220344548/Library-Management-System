import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;
public class FileManager {
	
	private String filePath;
	
	public FileManager(String filePath) {
        this.filePath = filePath;
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
	

}
