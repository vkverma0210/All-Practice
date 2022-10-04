import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class MostStonesRemovedWithSameRowOrColumn {
    public static int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int numOfIslands = 0;

        for (int[] s1 : stones) {
            if (!visited.contains(s1)) {
                dfs(s1, visited, stones);
                numOfIslands++;
            }
        }

        return stones.length - numOfIslands;
    }

    private static void dfs(int[] s1, Set<int[]> visited, int[][] stones) {
        visited.add(s1);

        for (int[] s2 : stones) {
            if (!visited.contains(s2)) {
                if (s1[0] == s2[0] || s1[1] == s2[1]) {
                    dfs(s2, visited, stones);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[][] stones = new int[n][2];

        for (int i = 0; i < n; i++) {
            stones[i][0] = scr.nextInt();
            stones[i][1] = scr.nextInt();
        }

        System.out.println(removeStones(stones));
        scr.close();
    }
}
