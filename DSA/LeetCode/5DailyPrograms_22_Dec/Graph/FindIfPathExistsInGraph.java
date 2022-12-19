import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindIfPathExistsInGraph {
    public static boolean found = false;

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(graph, visited, source, destination);
        return found;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int start, int end) {
        if (visited[start] || found) {
            return;
        }

        visited[start] = true;

        for (int next : graph.get(start)) {
            if (next == end) {
                found = true;
                return;
            }

            if (!visited[next]) {
                dfs(graph, visited, next, end);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int edge = scr.nextInt();
        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
            edges[i][0] = scr.nextInt();
            edges[i][1] = scr.nextInt();
        }

        int source = scr.nextInt();
        int destination = scr.nextInt();

        System.out.println(validPath(n, edges, source, destination));
        scr.close();
    }
}
