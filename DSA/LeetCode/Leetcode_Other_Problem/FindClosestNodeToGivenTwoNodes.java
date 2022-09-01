import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindClosestNodeToGivenTwoNodes {
    public static void bfs(int src, int[] dist, int[] edges, int n) {
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        dist[src] = 0;

        while (q.size() > 0) {
            var p = q.remove();
            if (edges[p] != -1 && dist[edges[p]] == Integer.MAX_VALUE) {
                q.add(edges[p]);
                dist[edges[p]] = dist[p] + 1;
            }
        }
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] PathNode1 = new int[n];
        int[] PathNode2 = new int[n];

        Arrays.fill(PathNode1, Integer.MAX_VALUE);
        Arrays.fill(PathNode2, Integer.MAX_VALUE);

        // call bfs
        bfs(node1, PathNode1, edges, n);
        bfs(node2, PathNode2, edges, n);

        // get node with manimum value of distance
        int res = Integer.MAX_VALUE, node = -1;

        for (int i = 0; i < n; i++) {
            if (PathNode1[i] == Integer.MAX_VALUE || PathNode2[i] == Integer.MAX_VALUE)
                continue;

            if (res > Math.max(PathNode1[i], PathNode2[i])) {
                node = i;
                res = Math.max(PathNode1[i], PathNode2[i]);

            }
        }

        return node;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] edges = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = scr.nextInt();
        }

        int node1 = scr.nextInt();
        int node2 = scr.nextInt();

        System.out.println(closestMeetingNode(edges, node1, node2));

        scr.close();
    }
}