import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortTheMatrixDiagonally {
    public static int[][] diagonalSort1(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map.putIfAbsent(i - j, new PriorityQueue<Integer>());
                map.get(i - j).add(mat[i][j]);
            }
        }

        int ans[][] = new int[mat.length][mat[0].length];

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                ans[i][j] = map.get(i - j).poll();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int m = scr.nextInt();
        int n = scr.nextInt();

        int[][] mat = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scr.nextInt();
            }
        }

        int[][] ans = diagonalSort(mat);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");

            }

            System.out.println();
        }

        scr.close();
    }
}
