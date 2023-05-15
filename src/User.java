import java.util.*;

public class User {
    private String email;
    private String phone;
    private String username;
    private String password;
    private String gender;
    private String job;
    private String birthday;
    private String address;
    private String relationshipStatus;
    private List<String> hobbies;
    private java.util.ArrayList<User> searchList = new ArrayList<>();
    private UserDataBase userDataBase;

    protected User(Builder builder) {
        this.email = builder.email;
        this.phone = builder.phone;
        this.username = builder.username;
        this.password = builder.password;
        this.gender = builder.gender;
        this.job = builder.job;
        this.hobbies = builder.hobbies;
        this.birthday = builder.birthday;
        this.address = builder.address;
    }
    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }
    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getJob() {
        return job;
    }
    public int getAge(){
        return getAge();
    }
    public void setRelationshipStatus(String relationshipStatus) {
        // Check if the new status is valid
        if (relationshipStatus.equals("Single") || relationshipStatus.equals("In a relationship") || 
            relationshipStatus.equals("Engaged") || relationshipStatus.equals("Married") || 
            relationshipStatus.equals("It's complicated")) {
            this.relationshipStatus = relationshipStatus;
        } else {
            System.out.println("Invalid relationship status");
        }
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public void searchUser(String Username){
        Scanner scan = new Scanner(System.in);
        String[] split = Username.split(" ");
        for(String name : split){
            if(userDataBase.containsUser(name)){
                System.out.println(userDataBase.getUser(name));
                searchList.add(userDataBase.getUser(name));
            }
        }
    }
    public static class Builder {
        private String email;
        private String phone;
        private String username;
        private String password;
        private String gender;
        private String job;
        private String birthday;
        private String address;
        private List<String> hobbies;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Builder hobbies(List<String> hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public Builder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
    public static class userAddFriend {
        private String username;
        private ArrayList<String> friendList;
        private HashMap<String, ArrayList<String>> friendsGraph; // Map username to friends list
        private HashMap<String, Integer> recommendedFriends; // Map username to recommendation score
        private Queue<String> friendRequestsQueue; // Queue of friend requests

        public userAddFriend(String username) {
            this.username = username;
            this.friendList = new ArrayList<>();
            this.friendsGraph = new HashMap<>();
            this.recommendedFriends = new HashMap<>();
            this.friendRequestsQueue = new LinkedList<>();
        }
        public void addRecommendedFriend(String friendUsername, int recommendationScore) { // Method for adding a new recommended friend to the graph
            if (!friendList.contains(friendUsername) && !recommendedFriends.containsKey(friendUsername)) { // Check if the recommended friend is not already in the friend list or recommended list
                recommendedFriends.put(friendUsername, recommendationScore);
                friendsGraph.put(friendUsername, new ArrayList<>());
            }
        }
        public void acceptFriendRequest(String friendUsername) { // Method for accepting a friend request and adding the friend to the friend list
            if (friendRequestsQueue.contains(friendUsername)) { // Check if the friend request exists in the friend request queue
                friendRequestsQueue.remove(friendUsername);
                friendList.add(friendUsername);
                friendsGraph.get(username).add(friendUsername);
                friendsGraph.get(friendUsername).add(username);
                System.out.println(friendUsername + " is now your friend!");
                System.out.println("Total Friend you have right now is : "+friendList.size());
            }
        }
        public void rejectFriendRequest(String friendUsername) { // Method for rejecting a friend request
            if (friendRequestsQueue.contains(friendUsername)) { // Check if the friend request exists in the friend request queue
                friendRequestsQueue.remove(friendUsername);
                System.out.println("You have rejected the friend request from " + friendUsername);
            }
        }
        public ArrayList<String> getRecommendedFriends() { // Method for getting the list of recommended friends sorted by recommendation score
            ArrayList<String> sortedFriends = new ArrayList<>();
            recommendedFriends.entrySet()
                    .stream()
                    .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())) // Sort by recommendation score in descending order
                    .forEach(entry -> sortedFriends.add(entry.getKey()));
            return sortedFriends;
        }
        public ArrayList<String> getFriendRequests() { // Method for getting the list of friend requests
            ArrayList<String> requests = new ArrayList<>(friendRequestsQueue);
            return requests;
        }
        public void sendFriendRequest(String friendUsername) { // Method for sending a friend request to another user
            if (!friendList.contains(friendUsername) && !friendRequestsQueue.contains(friendUsername)) { // Check if the friend is not already in the friend list or friend request queue
                friendRequestsQueue.add(friendUsername);
                System.out.println("Friend request sent to " + friendUsername);
            }
        }
        public void showNumberOfFriends(){
            System.out.println("Total Friend you have right now is : "+friendList.size());
        }
        public void showFriendList(){
            System.out.println("Your Friends");
            for(int i=0;i<friendList.size();i++){
                System.out.println(i+") "+friendList.get(i));
            }
        }
    }

}
