import java.util.Scanner;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] curr = new int[2];
        int[] front1 = new int[2];
        int[] front2 = new int[2];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 0) {
                    profit = Math.max(0 + front1[0], -prices[ind] + front1[1]);
                } else {
                    profit = Math.max(0 + front1[1], prices[ind] + front2[0]);
                }

                curr[buy] = profit;
            }

            front2 = (int[]) (front1.clone());
            front1 = (int[]) (curr.clone());
        }

        return curr[0];
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(maxProfit(nums));
        scr.close();
    }
}
