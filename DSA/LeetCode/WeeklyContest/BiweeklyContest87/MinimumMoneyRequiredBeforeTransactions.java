import java.util.Scanner;

public class MinimumMoneyRequiredBeforeTransactions {
    public static long minimumMoney(int[][] transactions) {
        long spend = 0, cashback = 0, cost = 0;

        for (int[] t : transactions) {
            if (t[0] > t[1]) {
                spend += t[0] - t[1];
                cashback = Math.max(cashback, (long) t[1]);
            } else {
                cost = Math.max(cost, (long) t[0]);
            }
        }

        return spend + Math.max(cashback, cost);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            nums[i][0] = scr.nextInt();
            nums[i][1] = scr.nextInt();
        }

        System.out.println(minimumMoney(nums));
        scr.close();
    }
}
