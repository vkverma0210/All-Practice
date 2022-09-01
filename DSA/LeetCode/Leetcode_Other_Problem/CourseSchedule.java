import java.util.ArrayList;
import java.util.Scanner;

public class CourseSchedule {
    public static boolean checkCycleDFS(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited,
            boolean[] dfsVisited) {
        visited[node] = true;
        dfsVisited[node] = true;

        for (int it : graph.get(node)) {
            if (!visited[it]) {
                if (checkCycleDFS(it, graph, visited, dfsVisited)) {
                    return true;
                }
            } else {
                if (dfsVisited[it]) {
                    return true;
                }
            }
        }

        dfsVisited[node] = false;
        return false;
    }

    public static boolean cycleDFS(int n, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[n];
        boolean[] dfsVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (checkCycleDFS(i, graph, visited, dfsVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] arr : prerequisites) {
            map.get(arr[0]).add(arr[1]);
        }

        if (cycleDFS(numCourses, map)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[][] nums = { { 1, 0 }, { 0, 1 } };

        boolean ans = canFinish(n, nums);

        System.out.println(ans);

        scr.close();
    }
}
