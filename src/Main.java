import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDataBase userDatabase = new UserDataBase();
        Registration registration = new Registration(userDatabase);
        Login login = new Login(userDatabase);

        Scanner scanner = new Scanner(System.in);

        while (true) {
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
                    login.authenticate();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}