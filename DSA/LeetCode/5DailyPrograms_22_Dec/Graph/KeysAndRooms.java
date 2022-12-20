import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        if (n == 0) {
            return true;
        }

        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    private static void dfs(int index, List<List<Integer>> rooms, boolean[] visited) {
        visited[index] = true;
        for (int n : rooms.get(index)) {
            if (!visited[n]) {
                dfs(n, rooms, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(Arrays.asList(1, 3)));
        rooms.add(new ArrayList<>(Arrays.asList(3, 0, 1)));
        rooms.add(new ArrayList<>(Arrays.asList(2)));
        rooms.add(new ArrayList<>(Arrays.asList(0)));

        System.out.println(rooms);
        System.out.println(canVisitAllRooms(rooms));
    }
}
