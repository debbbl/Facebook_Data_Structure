import java.util.*;

public class Registration {
    private UserDataBase userDatabase;

    public Registration(UserDataBase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public void showRegistrationForm() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your gender:");
        String gender = scanner.nextLine();
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        System.out.println("Please enter your phone:");
        String phone = scanner.nextLine();
        String password = enterPassword(scanner);
        System.out.println("Please enter your birthday (DD-MM-YYYY):");
        String birthday = scanner.nextLine();
        System.out.println("Please enter your address:");
        String address = scanner.nextLine();
        System.out.println("Please enter your job:");
        String job = scanner.nextLine();
        System.out.print("Enter hobbies (comma-separated): ");
        String hobbiesString = scanner.nextLine();
        List<String> hobbies = Arrays.asList(hobbiesString.split(","));

        User.Builder builder = new User.Builder()
                .email(email)
                .phone(phone)
                .username(name)
                .gender(gender)
                .job(job)
                .password(password)
                .hobbies(hobbies)
                .birthday(birthday)
                .address(address);;

        User user = builder.build();
        userDatabase.addUser(user);
        System.out.println("Registration successful!");
    }

    private String enterPassword(Scanner scanner) {
        while (true) {
            System.out.println("Please enter your password:");
            String password = scanner.nextLine();
            System.out.println("Please retype your password:");
            String retypePassword = scanner.nextLine();

            if (password.equals(retypePassword)) {
                return password;
            } else {
                System.out.println("Passwords do not match. Please try again.");
            }
        }
    }
}
