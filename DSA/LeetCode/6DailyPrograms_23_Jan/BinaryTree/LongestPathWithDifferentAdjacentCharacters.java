import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class LongestPathWithDifferentAdjacentCharacters {
    private static int ans = 1;

    public static int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            graph.get(parent[i]).add(i);
        }

        longestPathDFs(0, graph, s);

        return ans;
    }

    private static int longestPathDFs(int curr, List<List<Integer>> graph, String s) {
        int currentMax = 0;
        int secondMax = 0;

        for (int nextNode : graph.get(curr)) {
            int result = longestPathDFs(nextNode, graph, s);

            if (s.charAt(curr) == s.charAt(nextNode)) {
                continue;
            }

            if (result > currentMax) {
                secondMax = currentMax;
                currentMax = result;
            } else if (result > secondMax) {
                secondMax = result;
            }
        }

        ans = Math.max(ans, 1 + currentMax + secondMax);
        return 1 + currentMax;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = scr.nextInt();
        }

        String s = scr.next();
        System.out.println(longestPath(parent, s));
        scr.close();
    }
}
