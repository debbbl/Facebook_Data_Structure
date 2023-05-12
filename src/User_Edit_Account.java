import java.util.ArrayList;
import java.util.Stack;


public class User_Edit_Account {  //this is just same like the user account but there is some adjustment for edit account function (NO.3)
    private String name;
    private String password;
    private String email;
    private String phone;
    public String relationshipStatus;
    public ArrayList<String> hobbies;
    private Stack<String> jobExperiences;

    public User_Edit_Account(String name, String password,String email, String phone,String relationshipStatus) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.relationshipStatus = relationshipStatus;
        this.hobbies = new ArrayList<String>();
        this.jobExperiences = new Stack<String>();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public Stack<String> getJobExperiences() {
        return jobExperiences;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void addHobbies(ArrayList<Integer> choices) {
        for (int choice : choices) {
            switch (choice) {
                case 1:
                    hobbies.add("Sports");
                    break;
                case 2:
                    hobbies.add("Music");
                    break;
                case 3:
                    hobbies.add("Cooking");
                    break;
                case 4:
                    hobbies.add("Traveling");
                    break;
                case 5:
                    hobbies.add("Reading");
                    break;
                default:
                    System.out.println("Invalid hobby choice");
                    break;
            }
        }
        System.out.println("Your hobbies have been updated to: " + hobbies);
    }
    
    public void removeHobby(String hobby) {
        this.hobbies.remove(hobby);
    }
    
    public void addJobExperience(String jobExperience) {
        this.jobExperiences.push(jobExperience);
    }
    
    public void removeJobExperience() {
        this.jobExperiences.pop();
    }
    
    public void updateRelationshipStatus(String newStatus) {
        // Check if the new status is valid
        if (newStatus.equals("Single") || newStatus.equals("In a relationship") || 
            newStatus.equals("Engaged") || newStatus.equals("Married") || 
            newStatus.equals("It's complicated")) {
            this.relationshipStatus = newStatus;
        } else {
            System.out.println("Invalid relationship status");
        }
    }

    @Override
    public String toString() {
        return name + "," + password+","+email+","+phone+hobbies+this.relationshipStatus+this.jobExperiences;
    }
}
