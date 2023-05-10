import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class userAddFriend {
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

    // Method for adding a new recommended friend to the graph
    public void addRecommendedFriend(String friendUsername, int recommendationScore) {
        // Check if the recommended friend is not already in the friend list or recommended list
        if (!friendList.contains(friendUsername) && !recommendedFriends.containsKey(friendUsername)) {
            recommendedFriends.put(friendUsername, recommendationScore);
            friendsGraph.put(friendUsername, new ArrayList<>());
        }
    }

    // Method for accepting a friend request and adding the friend to the friend list
    public void acceptFriendRequest(String friendUsername) {
        // Check if the friend request exists in the friend request queue
        if (friendRequestsQueue.contains(friendUsername)) {
            friendRequestsQueue.remove(friendUsername);
            friendList.add(friendUsername);
            friendsGraph.get(username).add(friendUsername);
            friendsGraph.get(friendUsername).add(username);
            System.out.println(friendUsername + " is now your friend!");
        }
    }

    // Method for rejecting a friend request
    public void rejectFriendRequest(String friendUsername) {
        // Check if the friend request exists in the friend request queue
        if (friendRequestsQueue.contains(friendUsername)) {
            friendRequestsQueue.remove(friendUsername);
            System.out.println("You have rejected the friend request from " + friendUsername);
        }
    }

    // Method for getting the list of recommended friends sorted by recommendation score
    public ArrayList<String> getRecommendedFriends() {
        ArrayList<String> sortedFriends = new ArrayList<>();
        recommendedFriends.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())) // Sort by recommendation score in descending order
                .forEach(entry -> sortedFriends.add(entry.getKey()));
        return sortedFriends;
    }

    // Method for getting the list of friend requests
    public ArrayList<String> getFriendRequests() {
        ArrayList<String> requests = new ArrayList<>(friendRequestsQueue);
        return requests;
    }

    // Method for sending a friend request to another user
    public void sendFriendRequest(String friendUsername) {
        // Check if the friend is not already in the friend list or friend request queue
        if (!friendList.contains(friendUsername) && !friendRequestsQueue.contains(friendUsername)) {
            friendRequestsQueue.add(friendUsername);
            System.out.println("Friend request sent to " + friendUsername);
        }
    }
}
