import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumTimeToCollectAllApplesInATree {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return minTimeHelper(0, adj, hasApple, 0);
    }

    private static int minTimeHelper(int index, List<List<Integer>> adj, List<Boolean> hasApple, int parent) {
        int total = 0;
        for (int nbr : adj.get(index)) {
            if (nbr == parent) {
                continue;
            }

            total += minTimeHelper(nbr, adj, hasApple, index);
        }

        if (index != 0 && (hasApple.get(index) || total > 0)) {
            total += 2;
        }

        return total;
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
        List<Boolean> hasApple = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            Boolean x = scr.nextBoolean();
            hasApple.add(x);
        }

        System.out.println(minTime(n, edges, hasApple));
        scr.close();
    }
}
