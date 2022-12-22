import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumOfDistancesInTree {
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] counts = new int[n];
        Arrays.fill(counts, 1);

        int[] distanceSum = new int[n];

        postOrder(graph, 0, -1, counts, distanceSum);

        preOrder(graph, 0, -1, counts, distanceSum);

        return distanceSum;
    }

    private static void postOrder(ArrayList<Integer>[] graph, int currNode, int parentNode, int[] counts,
            int[] distanceSum) {
        for (int childNode : graph[currNode]) {
            if (childNode == parentNode)
                continue;

            postOrder(graph, childNode, currNode, counts, distanceSum);

            counts[currNode] += counts[childNode];

            distanceSum[currNode] += (distanceSum[childNode] + counts[childNode]);
        }
    }

    private static void preOrder(ArrayList<Integer>[] graph, int currNode, int parentNode, int[] counts,
            int[] distanceSum) {
        for (int childNode : graph[currNode]) {
            if (childNode == parentNode)
                continue;

            distanceSum[childNode] = distanceSum[currNode] + (graph.length - 2 * counts[childNode]);

            preOrder(graph, childNode, currNode, counts, distanceSum);
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int edge = scr.nextInt();
        int[][] edges = new int[edge][2];
        for (int i = 0; i < edge; i++) {
            edges[i][0] = scr.nextInt();
            edges[i][1] = scr.nextInt();
        }

        int[] ans = sumOfDistancesInTree(n, edges);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        System.out.println();
        scr.close();
    }
}