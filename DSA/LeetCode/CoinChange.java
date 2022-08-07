import java.util.Scanner;
import java.util.Arrays;

public class CoinChange {
    public static int minCoins(int amount, int[] coins, int[] dp) {
        // Base Case
        if (amount == 0) {
            return 0;
        }

        // Recursive Call
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int subProb = 0;

                if (dp[amount - coins[i]] != -1) {
                    subProb = dp[amount - coins[i]];
                } else {
                    subProb = minCoins(amount - coins[i], coins, dp);
                }

                if (subProb != Integer.MAX_VALUE && subProb + 1 < ans) {
                    ans = subProb + 1;
                }
            }
        }

        dp[amount] = ans;

        return dp[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans = minCoins(amount, coins, dp);

        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scr.nextInt();
        }

        int amount = scr.nextInt();

        int ans = coinChange(coins, amount);

        System.out.println(ans);

        scr.close();
    }
}
