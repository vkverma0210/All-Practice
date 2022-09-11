import java.util.Scanner;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int least_so_far = Integer.MAX_VALUE;
        int curr_max = 0;
        int max_so_far = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < least_so_far) {
                least_so_far = prices[i];
            }

            curr_max = prices[i] - least_so_far;

            max_so_far = Math.max(max_so_far, curr_max);
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
 
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = scr.nextInt();
        }

        System.out.println(maxProfit(prices));

        scr.close();
    }
}
