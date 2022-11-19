import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class ErecttheFence {
    private static int orientation(int[] p, int[] q, int[] r) {
        return ((r[1] - q[1]) * (q[0] - p[0])) - ((q[1] - p[1]) * (r[0] - q[0]));
    }

    public static int[][] outerTrees(int[][] trees) {
        Stack<int[]> upper = new Stack<>();
        Stack<int[]> lower = new Stack<>();
        Arrays.sort(trees, (p, q) -> q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);
        for (int i = 0; i < trees.length; i++) {
            while (lower.size() >= 2
                    && orientation(lower.get(lower.size() - 2), lower.get(lower.size() - 1), trees[i]) > 0) {
                lower.pop();
            }

            while (upper.size() >= 2
                    && orientation(upper.get(upper.size() - 2), upper.get(upper.size() - 1), trees[i]) < 0) {
                upper.pop();
            }

            lower.push(trees[i]);
            upper.push(trees[i]);
        }

        Set<int[]> res = new HashSet<>(lower);
        res.addAll(upper);

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[][] trees = new int[n][2];
        for (int i = 0; i < n; i++) {
            trees[i][0] = scr.nextInt();
            trees[i][1] = scr.nextInt();
        }

        int[][] ans = outerTrees(trees);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i][0] + " " + ans[i][1]);
            System.out.println();
        }

        scr.close();
    }

}