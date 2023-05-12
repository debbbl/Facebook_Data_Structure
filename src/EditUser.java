import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author acer-w
 */
public class EditUser  {
    private UserDataBase userDatabase;
    private String userName;
    
    public EditUser(UserDataBase userDatabase,String userName) {
        this.userDatabase = userDatabase;
        this.userName = userName;
    }
    
        public void edit() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Edit Own Account:");
            // Add code to handle editing own account
            System.out.println("1. Name");
            System.out.println("2. Gender");
            System.out.println("3. Email");
            System.out.println("4. Phone");
            System.out.println("5. Birthday (DD-MM-YYYY)");
            System.out.println("6. Address");
            System.out.println("7. Job");
            System.out.println("8. Hobbies (comma-separated");
            System.out.println("9. Relationship Status");
            System.out.print("Enter your choice: ");
            int choiceEdit = scanner.nextInt();
            scanner.nextLine();

            switch (choiceEdit) {
                        case 1:
                            System.out.print("Please enter your new name:");
                            String name = scanner.nextLine();
                            User userEditName = userDatabase.getUser(userName);
                            userEditName.setUsername(name);
                            userDatabase.updateUser(userEditName);

                            break;
                        case 2:
                            System.out.print("Please enter your new gender:");
                            String gender = scanner.nextLine();
                            User userEditGender = userDatabase.getUser(userName);
                            userEditGender.setGender(gender);
                            userDatabase.updateUser(userEditGender);

                            break;
                        case 3:
                            System.out.print("Please enter your new email:");
                            String email = scanner.nextLine();
                            User userEditEmail = userDatabase.getUser(userName);
                            userEditEmail.setEmail(email);
                            userDatabase.updateUser(userEditEmail);
                            break;
                        case 4:
                            System.out.print("Please enter your new phone:");
                            String phone = scanner.nextLine();
                            User userEditPhone = userDatabase.getUser(userName);
                            userEditPhone.setPhone(phone);
                            userDatabase.updateUser(userEditPhone);
                            
                            break;
                            
                        case 5:
                            System.out.print("Please enter your new birthday (DD-MM-YYYY):");
                            String birthday = scanner.nextLine();
                            User userEditBirthday = userDatabase.getUser(userName);
                            userEditBirthday.setBirthday(birthday);
                            userDatabase.updateUser(userEditBirthday);
                            
                            break;
                            
                        case 6:
                            System.out.print("Please enter your new address: ");
                            String address = scanner.nextLine();
                            User userEditAddress = userDatabase.getUser(userName);
                            userEditAddress.setAddress(address);
                            userDatabase.updateUser(userEditAddress);
                            break;
                            
                            
                        case 7:
                            System.out.print("Please enter your new job: ");
                            String job = scanner.nextLine();
                            User userEditJob = userDatabase.getUser(userName);
                            userEditJob.setJob(job);
                            userDatabase.updateUser(userEditJob);
                            break;
                        
                        case 8:
                            System.out.print("Please enter your new hobbies: ");
                            String hobbiesString = scanner.nextLine();
                            List<String> hobbies = Arrays.asList(hobbiesString.split(","));
                            User userEditHobbies = userDatabase.getUser(userName);
                            userEditHobbies.setHobbies(hobbies);
                            userDatabase.updateUser(userEditHobbies);
                            break;
                            
                        case 9:
                            System.out.print("Please enter your new relationship status: ");
                            String relationshipStatus = scanner.nextLine();
                            User userEditRelationship = userDatabase.getUser(userName);
                            userEditRelationship.setRelationshipStatus(relationshipStatus);
                            userDatabase.updateUser(userEditRelationship );
                            break;
                            
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
            }
        }
}
