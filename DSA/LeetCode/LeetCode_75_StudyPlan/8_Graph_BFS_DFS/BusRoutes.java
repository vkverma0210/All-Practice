import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BusRoutes {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> buses = new HashMap<>();

        int res = 0;

        if (source == target) {
            return 0;
        }

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> bus = buses.getOrDefault(routes[i][j], new ArrayList<>());
                bus.add(i);
                buses.put(routes[i][j], bus);
            }
        }

        queue.offer(source);

        while (!queue.isEmpty()) {
            int len = queue.size();
            res++;

            for (int i = 0; i < len; i++) {
                int curr = queue.poll();
                ArrayList<Integer> bus = buses.get(curr);

                for (int b : bus) {
                    if (visited.contains(b)) {
                        continue;
                    }

                    visited.add(b);

                    for (int j = 0; j < routes[b].length; j++) {
                        if (routes[b][j] == target) {
                            return res;
                        }

                        queue.offer(routes[b][j]);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[][] routes = new int[n][];

        for (int i = 0; i < n; i++) {
            int m = scr.nextInt();
            int[] r = new int[m];
            for (int j = 0; j < m; j++) {
                r[j] = scr.nextInt();
            }

            routes[i] = r;
        }

        int source = scr.nextInt();
        int target = scr.nextInt();
        System.out.println(numBusesToDestination(routes, source, target));
        scr.close();
    }
}
