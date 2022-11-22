import java.util.Scanner;

public class PerfectSquares {
    // 1. Recursive Approach
    public static int numSquares1(int n) {
        if (n < 4) {
            return n;
        }

        int ans = n;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + numSquares1(n - square));
        }

        return ans;
    }

    // 2. Memoization Approach
    public static int numSquares2(int n) {
        int[] dp = new int[n + 1];
        return numSquares2Helper(n, dp);
    }

    public static int numSquares2Helper(int n, int[] dp) {
        if (n < 4) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int ans = n;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + numSquares2Helper(n - square, dp));
        }

        return dp[n] = ans;
    }

    // 3. tabulation Approach
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        System.out.println(numSquares1(n));
        System.out.println(numSquares2(n));
        System.out.println(numSquares(n));
        scr.close();
    }
}