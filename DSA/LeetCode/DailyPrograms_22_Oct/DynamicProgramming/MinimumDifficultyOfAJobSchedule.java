import java.util.Arrays;
import java.util.Scanner;

public class MinimumDifficultyOfAJobSchedule {
    // 1. Recursion
    public static int minDifficulty1(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) {
            return -1;
        }

        return dfs1(jobDifficulty, d - 1, 0);
    }

    private static int dfs1(int[] jobDifficulty, int d, int pos) {
        // base case
        if (d == 0) {
            int max = jobDifficulty[pos];

            for (int i = pos; i < jobDifficulty.length; i++) {
                max = Math.max(max, jobDifficulty[i]);
            }

            return max;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // try out all ranges for that day
        for (int i = pos; i < jobDifficulty.length - d; i++) {
            max = Math.max(max, jobDifficulty[i]);
            min = Math.min(min, max + dfs1(jobDifficulty, d - 1, i + 1));
        }

        return min;
    }

    // 2. Recursion + Memoziation
    public static int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) {
            return -1;
        }

        int[][] memo = new int[d - 1][jobDifficulty.length];
        for (int[] day : memo) {
            Arrays.fill(day, -1);
        }

        return dfs(jobDifficulty, d - 1, 0, memo);
    }

    private static int dfs(int[] jobDifficulty, int d, int pos, int[][] cache) {
        // base case
        if (d == 0) {
            int max = jobDifficulty[pos];

            for (int i = pos; i < jobDifficulty.length; i++) {
                max = Math.max(max, jobDifficulty[i]);
            }

            return max;
        }

        int day = cache.length - d;

        if (cache[day][pos] != -1) {
            return cache[day][pos];
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // try out all ranges for that day
        for (int i = pos; i < jobDifficulty.length - d; i++) {
            max = Math.max(max, jobDifficulty[i]);
            min = Math.min(min, max + dfs(jobDifficulty, d - 1, i + 1, cache));
        }

        return cache[day][pos] = min;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] jobDifficulty = new int[n];

        for (int i = 0; i < n; i++) {
            jobDifficulty[i] = scr.nextInt();
        }

        int d = scr.nextInt();

        System.out.println(minDifficulty1(jobDifficulty, d));
        System.out.println(minDifficulty(jobDifficulty, d));

        scr.close();
    }
}