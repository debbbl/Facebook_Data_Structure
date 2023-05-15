import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDataBase {
    private List<User> users;
    private File dataFile;

    public UserDataBase() {
        users = new ArrayList<>();
        dataFile = new File("userdata.csv");
        readUsersFromFile();
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
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public User findUserByEmailOrPhone(String emailOrPhone) {
        for (User user : users) {
            if (user.getEmail().equals(emailOrPhone) || user.getPhone().equals(emailOrPhone)) {
                return user;
            }
        }
        return null;
    }

    private void readUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                User.Builder builder = new User.Builder()
                        .email(userData[0])
                        .phone(userData[1])
                        .username(userData[2])
                        .password(userData[3])
                        .gender(userData[4])
                        .job(userData[5])
                        .birthday(userData[6])
                        .address(userData[7])
                        .hobbies(List.of(userData[8].split(";")));         User user = builder.build();
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.err.println("User data file not found. Creating a new file.");
        } catch (IOException e) {
            System.err.println("Error reading user data from file: " + e.getMessage());
        }
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            for (User user : users) {
                StringBuilder userData = new StringBuilder();
                userData.append(user.getEmail()).append(",")
                        .append(user.getPhone()).append(",")
                        .append(user.getUsername()).append(",")
                        .append(user.getPassword()).append(",")
                        .append(user.getGender()).append(",")
                        .append(user.getJob()).append(",")
                        .append(user.getBirthday()).append(",")
                        .append(user.getAddress()).append(",")
                        .append(String.join(";", user.getHobbies()));
                writer.write(userData.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing user data to file: " + e.getMessage());
        }
    }
}
