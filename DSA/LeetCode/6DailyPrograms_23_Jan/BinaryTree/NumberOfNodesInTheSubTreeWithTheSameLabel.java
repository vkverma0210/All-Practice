import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] ans = new int[n];
        int[] visited = new int[n];
        finddfs(0, graph, ans, labels, visited);

        return ans;
    }

    private static int[] finddfs(int node, List<List<Integer>> graph, int[] ans, String labels, int[] visited) {
        int[] curr = new int[26];
        visited[node] = 1;

        for (int i : graph.get(node)) {
            if (visited[i] == 0) {
                int[] contains = finddfs(i, graph, ans, labels, visited);

                for (int ind = 0; ind < 26; ind++) {
                    curr[ind] += contains[ind];
                }
            }
        }

        curr[labels.charAt(node) - 'a']++;
        ans[node] = curr[labels.charAt(node) - 'a'];

        return curr;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int edge = scr.nextInt();
        int[][] edges = new int[edge][2];
        for (int i = 0; i < edge; i++) {
            edges[i][0] = scr.nextInt();
            edges[i][1] = scr.nextInt();
        }

        int n = scr.nextInt();
        String labels = scr.next();
        int[] ans = countSubTrees(n, edges, labels);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        System.out.println();
        scr.close();
    }
}
