import java.util.Arrays;
import java.util.Scanner;

public class NumberOfDiceRollsWithTargetSum {
    // 1. Recursive
    // Time: O(k ^ n). Space: O(n) for the recursion stack
    public static int numRollsToTarget1(int n, int k, int target) {
        if (target < 0) {
            return 0;
        }

        if (n == 0 && target != 0) {
            return 0;
        }

        if (target == 0 && n != 0) {
            return 0;
        }

        if (n == 0 && target == 0) {
            return 1;
        }

        int ans = 0;

        for (int i = 1; i <= k; i++) {
            ans += numRollsToTarget1(n - 1, k, target - i);
        }

        return ans;
    }

    // 2. Recursive + Memoziation (Top-down)
    // Time: O(n * k * target). Space: O(n * target) for the memoisation
    public static int numRollsToTarget2_Helper(int n, int k, int target, int[][] dp) {
        int mod = (int) (1e9 + 7);

        if (target < 0) {
            return 0;
        }

        if (n == 0 && target != 0) {
            return 0;
        }

        if (target == 0 && n != 0) {
            return 0;
        }

        if (n == 0 && target == 0) {
            return 1;
        }

        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        int ans = 0;

        for (int i = 1; i <= k; i++) {
            ans = (ans + numRollsToTarget2_Helper(n - 1, k, target - i, dp)) % mod;
        }

        return dp[n][target] = ans;
    }

    public static int numRollsToTarget2(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return numRollsToTarget2_Helper(n, k, target, dp);
    }

    // 3. Bottom-Up DP
    // Time: O(n * k * target). Space: O(n * target) for the memoisation

    public static int numRollsToTarget3(int n, int k, int target) {
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int ans = 0;

                for (int f = 1; f <= k; f++) {
                    if (j - f >= 0) {
                        ans = (ans + dp[i - 1][j - f]) % mod;
                    }
                }

                dp[i][j] = ans;
            }
        }

        return dp[n][target];
    }

    // 3. Bottom-Up DP Time and Space Complexity Optimizations
    // Time: O(n * k * target). Space: O(target) for the memoisation

    public static int numRollsToTarget4(int n, int k, int target) {
        int mod = (int) (1e9 + 7);
        int[] prev = new int[target + 1];
        int[] curr = new int[target + 1];

        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int ans = 0;

                for (int f = 1; f <= k; f++) {
                    if (j - f >= 0) {
                        ans = (ans + prev[j - f]) % mod;
                    }
                }

                curr[j] = ans;
            }

            prev = curr.clone();
        }

        return prev[target];
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int k = scr.nextInt();
        int target = scr.nextInt();

        // System.out.println(numRollsToTarget1(n, k, target));
        System.out.println(numRollsToTarget2(n, k, target));
        System.out.println(numRollsToTarget3(n, k, target));
        System.out.println(numRollsToTarget4(n, k, target));

        scr.close();
    }
}
