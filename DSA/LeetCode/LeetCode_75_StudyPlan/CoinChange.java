import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {
    // 1. Recursive O(n^s) s = amount
    public static int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int coinCount = -1;

        for (int i = 0; i < coins.length; i++) {
            int coin = coinChange1(coins, amount - coins[i]);

            if (coin >= 0) {
                coinCount = coinCount < 0 ? coin + 1 : Math.min(coinCount, coin + 1);
            }
        }

        return coinCount;
    }

    // 2. Recursive + memo O(ns)
    public static int coinChange2(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        return coinChange2Helper(coins, amount, map);
    }

    public static int coinChange2Helper(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        Integer c = memo.get(amount);

        if (c != null) {
            return c;
        }

        int coinCount = -1;

        for (int i = 0; i < coins.length; i++) {
            int coin = coinChange2Helper(coins, amount - coins[i], memo);

            if (coin >= 0) {
                coinCount = coinCount < 0 ? coin + 1 : Math.min(coinCount, coin + 1);
            }
        }

        memo.put(amount, coinCount);
        return coinCount;
    }

    // 3. DP O(ns)
    public static int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans = coinChange3Helper(coins, amount, dp);

        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    public static int coinChange3Helper(int[] coins, int amount, int[] dp) {
        // base Case
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
                    subProb = coinChange3Helper(coins, amount - coins[i], dp);
                }

                if (subProb != Integer.MAX_VALUE && subProb + 1 < ans) {
                    ans = subProb + 1;
                }
            }
        }

        dp[amount] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scr.nextInt();
        }

        int amount = scr.nextInt();

        System.out.println(coinChange1(coins, amount));
        System.out.println(coinChange2(coins, amount));
        System.out.println(coinChange3(coins, amount));
        scr.close();
    }
}
