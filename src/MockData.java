import java.io.*;
import java.util.*;

public class MockData {
    private int id;
    private String name;
    private String email;
    private boolean isAdmin;

    public MockData(int id, String name, String email, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    // Getters and setters

    public static void main(String[] args) {
        String filePath = "users.data";
        FileDataStore dataStore = new FileDataStore(filePath);

        List<MockData> users;
        try {
            users = dataStore.loadUsers();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (users == null || users.isEmpty()) {
            // Generate initial data
            for (int i = 1; i <= 30; i++) {
                MockData user = new MockData(i, "User " + i, "user" + i + "@example.com", false);
                users.add(user);
            }

            for (int i = 31; i <= 32; i++) {
                MockData admin = new MockData(i, "Admin " + (i - 30), "admin" + (i - 30) + "@example.com", true);
                users.add(admin);
            }

            try {
                dataStore.saveUsers(users);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        // Use the users data for business operations
        for (MockData user : users) {
            System.out.println(user.name + " - " + (user.isAdmin() ? "Admin" : "Normal User"));
        }
    }


    public boolean isAdmin() {
        return isAdmin;
    }

}

class FileDataStore {
    private String filePath;

    public FileDataStore(String filePath) {
        this.filePath = filePath;
    }

    public void saveUsers(List<MockData> users) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(users);
        }
    }

    public List<MockData> loadUsers() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            try {
                return (List<MockData>) inputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }
    }
}
