import java.util.Scanner;

public class Login {
    private UserDatabase userDatabase;

    public Login(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // verify
        authenticate();
    }
    private static void authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email or phone number: ");
        String emailOrPhone = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = userDatabase.findUserByEmailOrPhone(emailOrPhone);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Welcome, " + user.getUsername() + "!");
        } else {
            System.out.println("Invalid email/phone or password. Please try again.");
        }
    }
}


