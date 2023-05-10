import java.util.*;

public class MutualFriends {
    private Map<String, List<String>> graph;

    public MutualFriends() {
        graph = new HashMap<>();
    }

    public void addFriendship(String person1, String person2) {
        graph.putIfAbsent(person1, new ArrayList<>());
        graph.putIfAbsent(person2, new ArrayList<>());
        graph.get(person1).add(person2);
        graph.get(person2).add(person1);
    }

    public List<String> getMutualFriends(String person1, String person2) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        List<String> mutualFriends = new ArrayList<>();

        queue.offer(person1);
        distances.put(person1, 0);
        parents.put(person1, null);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(person2)) {
                break;
            }
            for (String neighbor : graph.get(current)) {
                if (!distances.containsKey(neighbor)) {
                    distances.put(neighbor, distances.get(current) + 1);
                    parents.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        if (!parents.containsKey(person2)) {
            System.out.println("No mutual friends found.");
            return mutualFriends;
        }

        String current = person2;
        while (current != null) {
            if (!current.equals(person1) && !current.equals(person2)) {
                mutualFriends.add(current);
            }
            current = parents.get(current);
        }

        return mutualFriends;
    }
}
