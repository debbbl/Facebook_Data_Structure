import java.io.*;
import java.util.*;
public class UserDataBase {  //this is use for determine exist of data, update edited data and store data in txt

    private ArrayList<User> users;
    private File dataFile;

    public UserDataBase() {
        users = new ArrayList<>();
        dataFile = new File("userdata.txt");
    }

    public void addUser(User user) {
        users.add(user);
        saveUsersToFile();
    }

    
    public void updateUser(User user) {
        int index = users.indexOf(user);
        if (index != -1) {
            users.set(index, user);
            saveUsersToFile();
        }
    }
    
    public boolean containsUser(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    public User getUser(String username)
    {
        for (User user : users) 
        {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {
        return new ArrayList<>(users);
    }
    
    public User findUserByEmailOrPhone(String emailOrPhone)
    {
        for (User user : users) 
        {
            if (user.getEmail().equals(emailOrPhone)|| user.getPhone().equals(emailOrPhone)) {
                return user;
            }
        }
        return null;
    }
        
    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            for (User user : users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing user data to file: " + e.getMessage());
        }
    }
}
