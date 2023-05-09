public class Main { //here is the example output for the NO.1 & NO.3, but only use a little amount of user, if more user maybe need to adjust the code
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        UserDataBase userManager = new UserDataBase();
        User user1 = new User("user1", "password1","1shdiehd","019293874","marrry");
        User user2 = new User("user2", "password2","hdiqedug","129232","marry");
        
        userManager.addUser(user1);
        userManager.addUser(user2);
        
        // add more users here

        if(userManager.containsUser("user1"))
        {
            User user = userManager.getUser("user1");
            user.setPassword("newpassword");
            userManager.updateUser(user);
        }
        
        else{
            System.out.println("The user name is not found in the data");
        }
        
        System.out.println("Choose your relationship status:");
        System.out.println("1. Single\n2. In a relationship\n3. Engaged\n4. Married\n5. It's complicated");
        System.out.print("Enter the number of your choice: ");
        int relationshipChoice = sc.nextInt();
        switch (relationshipChoice) {
            case 1:
                user1.updateRelationshipStatus("Single");
                break;
            case 2:
                user1.updateRelationshipStatus("In a relationship");
                break;
            case 3:
                user1.updateRelationshipStatus("Engaged");
                break;
            case 4:
                user1.updateRelationshipStatus("Married");
                break;
            case 5:
                user1.updateRelationshipStatus("It's complicated");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
        System.out.println("Your relationship status has been updated to: " + user1.relationshipStatus);
        
        System.out.println("\nChoose your hobbies (separated by commas):");
        System.out.println("1. Sports\n2. Music\n3. Cooking\n4. Traveling\n5. Reading");
        System.out.print("Enter the numbers of your choices: ");
        sc.nextLine(); // after nextInt cant just sc.nextLine, need consume the new line character after nextInt()
        String hobbiesInput = sc.nextLine();
        String[] hobbiesArray = hobbiesInput.split(",");
        user1.hobbies.clear();
        for (String hobby : hobbiesArray) {
            switch (hobby.trim()) {
                case "1":
                    user1.hobbies.add("Sports");
                    break;
                case "2":
                    user1.hobbies.add("Music");
                    break;
                case "3":
                    user1.hobbies.add("Cooking");
                    break;
                case "4":
                    user1.hobbies.add("Traveling");
                    break;
                case "5":
                    user1.hobbies.add("Reading");
                default:
                System.out.println("Invalid choice.");
                break;
            }
        }
        
        System.out.println("Enter the current job:");
        String currentJob = sc.nextLine();
        user1.addJobExperience(currentJob);
        
        System.out.println("Enter the new job:");
        String newJob = sc.nextLine();
        user1.addJobExperience(newJob);
        userManager.updateUser(user1); //must put update to update the status else it will remain the same
        
        

        // retrieve all users
        try (BufferedReader reader  = new BufferedReader(new FileReader("userdata.txt"))) {
            String line =" ";
            while((line=reader.readLine())!=null)
            {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error writing user data to file: " + e.getMessage());
        }
    }
}
