import java.sql.*;

public class MockData {
    private int id;
    private String name;
    private String email;
    private boolean isAdmin;

    public User(int id, String name, String email, boolean isAdmin) {
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
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();

            // Create table if it doesn't exist
            String createTable = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255), isAdmin BOOLEAN)";
            statement.executeUpdate(createTable);

            // Insert mock data
            String insertData = "INSERT INTO users (id, name, email, isAdmin) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertData);
            for (int i = 1; i <= 30; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "User " + i);
                preparedStatement.setString(3, "user" + i + "@example.com");
                preparedStatement.setBoolean(4, false);
                preparedStatement.executeUpdate();
            }
            for (int i = 31; i <= 32; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "Admin " + i);
                preparedStatement.setString(3, "admin" + i + "@example.com");
                preparedStatement.setBoolean(4, true);
                preparedStatement.executeUpdate();
            }

            // Retrieve data
            String retrieveData = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(retrieveData);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                User user = new User(id, name, email, isAdmin);
                System.out.println(user.getName() + " (" + user.getEmail() + ")" + (user.isAdmin() ? " - Admin" : ""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
