import java.util.*;

public class Registration {
    private UserDatabase userDatabase;

    public Registration(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }
    public void showRegistrationForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your gender");
        String gender=scanner.nextLine();
        System.out.println("Please enter your email");
        String email=scanner.nextLine();
        System.out.println("Please enter your phone ");
        String phone=scanner.nextLine();
        System.out.println("Please enter your password");
        String password=scanner.nextLine();
        System.out.println("Please enter your birthday ");
        String birthday=scanner.nextLine();
        System.out.println("Please enter your address");
        String address=scanner.nextLine();
        System.out.println("Please enter your job");
        String job=scanner.nextLine();
        System.out.print("Enter hobbies (comma-separated): ");
        String hobbiesString = scanner.nextLine();
        List<String> hobbies = new ArrayList<>();
        for (String hobby : hobbiesString.split(",")) {
            hobbies.add(hobby.trim());
        }
        User.Builder builder = new User.Builder();
        builder.email(email)
                .phone(phone)
                .username("username")
                .password(password)
                .hobbies(hobbies);
        User user = builder.build();
    }

    public void submitRegistration(String username, String email, String phone, String password,
                                   String name, String birthday, String gender, String address,
                                   String job, List<String> hobbies) {
        // Check if useraccount already exists
        if (userDatabase.containsUser(username)) {//method in database
            System.out.println("User exists");

        }else {
            userDatabase.add(user);//method in database
            System.out.println("Registration successful!");
        }
        return;
    }


}
}
