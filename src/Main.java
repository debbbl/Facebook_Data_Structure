import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDataBase userDatabase = new UserDataBase();
        Registration registration = new Registration(userDatabase);
        Login login = new Login(userDatabase);
        ViewProfile viewProfile = new ViewProfile(userDatabase);

        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String loggedInUsername = null;

        while (true) {
            if (!loggedIn) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Registration Form:");
                        registration.showRegistrationForm();
                        break;
                    case 2:
                        System.out.println("Login:");
                        loggedInUsername = login.authenticate();
                        if (loggedInUsername != null) {
                            loggedIn = true;
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Invalid username or password. Please try again.");
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } else {
                System.out.println("1. View Profile");
                System.out.println("2. Edit Own Account");
                System.out.println("3. Logout");
                System.out.println("4. Go Back");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("View Profile:");
                        viewProfile.searchUser();
                        break;
                    case 2:
                        System.out.println("Edit Own Account:");
                        // Add code to handle editing own account
                        break;
                    case 3:
                        loggedIn = false;
                        loggedInUsername = null;
                        System.out.println("Logged out successfully.");
                        break;
                    case 4:
                        // Go back to the previous menu
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

                if (choice == 4) {
                    continue;
                }
            }
        }
    }
}