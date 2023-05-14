import java.util.Scanner;

public class ViewProfile {
    private UserDataBase userDatabase;

    public ViewProfile(UserDataBase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public void searchUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the username to search: ");
        String username = scanner.nextLine();

        User user = userDatabase.getUser(username);
        if (user != null) {
            displayProfile(user);
        } else {
            System.out.println("User not found");
        }
    }

    private void displayProfile(User user) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Age: " + user.getAge());
        System.out.println("Gender: " + user.getGender());
        System.out.println("Phone: " + user.getPhone());
        System.out.println("Birthday: " + user.getBirthday());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Job: " + user.getJob());
        System.out.println("Hobbies: " + String.join(", ", user.getHobbies()));
    }
}