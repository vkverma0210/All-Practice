import java.util.Scanner;

public class BestTimeToBuyAndSellStockIV {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // Case 1: n <= 1 OR k == 0
        if (k == 0 || n <= 1) {
            return 0;
        }

        // Case 2: k >= n
        if (2 * k > n) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += (prices[i] - prices[i - 1]);
                }
            }

            return res;
        }

        // case 3: 1 <= k <= n
        int[] dp = new int[2 * k + 1];
        dp[0] = -prices[0];

        for (int i = 1; i <= 2 * k; i++) {
            if (i % 2 == 0) // Buy
                dp[i] = Integer.MIN_VALUE;
            else // SELL
                dp[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 2 * k; j++) {
                if (j == 0) {
                    dp[j] = Math.max(dp[j], -prices[i]);
                } else if (j % 2 == 0) // BUY
                {
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else // SELL
                {
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }

        return dp[2 * k - 1];
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int k = scr.nextInt();

        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = scr.nextInt();
        }

        System.out.println(maxProfit(k, prices));
        scr.close();
    }
}
