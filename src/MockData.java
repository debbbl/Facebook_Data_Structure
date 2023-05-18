import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MockData<T> {
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Userdatabase";
        String username = "your_username";
        String password = "your_password";

        SqlDataStore<MockData> dataStore = new SqlDataStore<>(url, username, password);

        List<MockData> users;
        try {
            users = dataStore.loadEntities(MockData.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        if (users.isEmpty()) {
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
                dataStore.saveEntities(users);
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
        }

        // Use the users data for business operations
        for (MockData user : users) {
            System.out.println(user.getName() + " - " + (user.isAdmin() ? "Admin" : "Normal User"));
        }
    }
}

class SqlDataStore<T> {
    private String url;
    private String username;
    private String password;

    public SqlDataStore(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void saveEntities(List<T> entities) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO entities (id, name, email, isAdmin) VALUES (?, ?, ?, ?)")) {
            for (T entity : entities) {
                if (entity instanceof MockData) {
                    MockData mockData = (MockData) entity;
                    statement.setInt(1, mockData.getId());
                    statement.setString(2, mockData.getName());
                    statement.setString(3, mockData.getEmail());
                    statement.setBoolean(4, mockData.isAdmin());
                    statement.executeUpdate();
                }
                // Add more 'if' conditions for other entity types as needed
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<T> loadEntities(Class<T> entityClass) throws SQLException {
        List<T> entities = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM entities")) {
            while (resultSet.next()) {
                if (entityClass.equals(MockData.class)) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    boolean isAdmin = resultSet.getBoolean("isAdmin");
                    MockData mockData = new MockData(id, name, email, isAdmin);
                    entities.add(entityClass.cast(mockData));
                }
                // Add more 'if' conditions for other entity types as needed
            }
        } catch (SQLException e) {
            throw e;
        }
        return entities;
    }
}
