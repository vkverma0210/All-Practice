import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BuildaMatrixWithConditions {
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = GenerateTopologicalSort(rowConditions, k);
        List<Integer> colOrder = GenerateTopologicalSort(rowConditions, k);

        if (rowOrder.size() < k || colOrder.size() < k)
            return new int[0][0];

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < k; i++)
            mp.put(colOrder.get(i), i);

        int[][] ans = new int[k][k];

        for (int i = 0; i < k; i++)
            ans[i][mp.get(rowOrder.get(i))] = rowOrder.get(i);

        return ans;
    }

    private static List<Integer> GenerateTopologicalSort(int[][] A, int k) {
        int[] deg = new int[k];
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < k; i++)
            graph.add(new ArrayList<>());

        Queue<Integer> q = new LinkedList<>();

        for (int[] c : A) {
            graph.get(c[0] - 1).add(c[1] - 1);
            deg[c[1] - 1]++;
        }

        for (int i = 0; i < k; i++)
            if (deg[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int x = q.poll();

            order.add(x + 1);

            for (int y : graph.get(x))
                if (--deg[y] == 0)
                    q.add(y);
        }

        return order;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int k = scr.nextInt();

        int n = scr.nextInt();
        int[][] rowConditions = new int[n][2];

        for (int i = 0; i < n; i++) {
            rowConditions[i][0] = scr.nextInt();
            rowConditions[i][1] = scr.nextInt();
        }

        int m = scr.nextInt();
        int[][] colConditions = new int[m][2];

        for (int i = 0; i < m; i++) {
            colConditions[i][0] = scr.nextInt();
            colConditions[i][1] = scr.nextInt();
        }

        int[][] ans = new int[k][k];

        ans = buildMatrix(k, rowConditions, colConditions);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }

        scr.close();
    }
}
