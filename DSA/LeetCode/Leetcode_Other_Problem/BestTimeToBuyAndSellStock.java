import java.util.Scanner;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int leastSoFar = Integer.MAX_VALUE;
        int overallProfit = 0;
        int currentProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastSoFar) {
                leastSoFar = prices[i];
            }

            currentProfit = prices[i] - leastSoFar;

            overallProfit = Math.max(currentProfit, overallProfit);
        }
        return overallProfit;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = scr.nextInt();
        }

        int ans = maxProfit(prices);

        System.out.println(ans);

        scr.close();
    }
}
