import java.util.Arrays;
import java.util.Scanner;

public class MaximumIceCreamBars {
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int n = costs.length;
        int ans = 0;

        while (ans < n && costs[ans] <= coins) {
            coins -= costs[ans];
            ans += 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = scr.nextInt();
        }

        int coins = scr.nextInt();

        System.out.println(maxIceCream(costs, coins));
        scr.close();
    }
}
