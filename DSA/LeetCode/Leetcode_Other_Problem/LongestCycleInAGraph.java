import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LongestCycleInAGraph {
    // To keep track of visited nodes
    static boolean[] visited;

    // maximum cycle length in each component of graph
    static int maxbig = Integer.MIN_VALUE;

    // Hashmap to keep track of elements indices in the sequence of the cycle of a
    // node is visited we enter its index if node is visited twice ->then the cycle
    // can be obtainbed from list from the node's first index to.
    static HashMap<Integer, ArrayList<Integer>> map;

    public static int longestCycle(int[] edges) {
        visited = new boolean[edges.length];

        // absolute max length of cycle
        int max = Integer.MIN_VALUE;

        // traversing through components
        for (int i = 0; i < edges.length; i++) {
            // if not visited only then do dfs
            if (!visited[i]) {
                // put declaration for new instance every time we go into a component
                map = new HashMap<Integer, ArrayList<Integer>>();

                // source, edges, and a new arraylist to keep track of a potential cycle removed
                // new arraylist
                dfs(i, edges);

                // after dfs find maximum length cycle
                max = Math.max(max, maxbig);

                maxbig = Integer.MIN_VALUE;
            }
        }

        if (max == Integer.MIN_VALUE) {
            return -1;
        }

        return max;
    }

    public static void dfs(int source, int[] edges) {
        // if source is -1 return
        if (source == -1)
            return;

        // if the map does not contain the node key create one
        if (!map.containsKey(source)) {
            map.put(source, new ArrayList<Integer>());
        }

        // put index of source using size of map
        map.get(source).add(map.size());

        // mark source as visited
        visited[source] = true;

        // if edges[source] is not -1
        if (edges[source] != -1) {

            // if edges[source] is visited
            if (visited[edges[source]]) {

                // if edges[source] was not visited in this iteration i.e. it was visited in
                // some other iteration and its cycle has been considered
                if (!map.containsKey(edges[source])) {
                    return;
                }

                // if it was visited in this iteration the length of the cycle would be
                // map.size() + 1 - the first time the same node was visited
                maxbig = Math.max(map.size() + 1 - map.get(edges[source]).get(0), maxbig);
                return;
            }

            // if not visited visit it
            dfs(edges[source], edges);
        }

        return;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int ans = longestCycle(nums);

        System.out.println(ans);

        scr.close();
    }
}
