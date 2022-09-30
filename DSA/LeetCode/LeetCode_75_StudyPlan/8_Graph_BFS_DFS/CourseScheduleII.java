import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // bulid the adjency list, with each course acting as a node
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {

            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // this array is to track the visited node, initally all nodes are in state
        // 0(unvisited)
        int[] visited = new int[numCourses];
        List<Integer> res = new ArrayList<>();

        // perform dfs on each node in the graph as the graph may not be fully
        // connected.
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == 0) {
                if (topologicalSort(i, res, adj, visited) == false) {
                    return new int[0];
                }
            }
        }

        // if no cycle were found than we can copy the arraylist to an array and return
        int[] ans = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    private static boolean topologicalSort(int curr, List<Integer> res, List<List<Integer>> adj, int[] visited) {
        visited[curr] = 1; // mark the current node with state 1(visiting)
        List<Integer> neighbours = adj.get(curr); // get all neighbouring nodes

        for (Integer i : neighbours) {
            // if one of the neighbours is also being visited then there ia a cysle
            if (visited[i] == 1) {
                return false;
            }

            if (visited[i] == 0) {
                // perform topological sort on all unvisited neighbours
                if (topologicalSort(i, res, adj, visited) == false) {
                    return false;
                }
            }
        }

        visited[curr] = 2;
        res.add(curr);

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int numCourses = scr.nextInt();

        int n = scr.nextInt();
        int[][] prerequisites = new int[n][2];

        for (int i = 0; i < n; i++) {
            prerequisites[i][0] = scr.nextInt();
            prerequisites[i][1] = scr.nextInt();
        }

        int[] ans = findOrder(numCourses, prerequisites);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        System.out.println();
        scr.close();
    }
}
