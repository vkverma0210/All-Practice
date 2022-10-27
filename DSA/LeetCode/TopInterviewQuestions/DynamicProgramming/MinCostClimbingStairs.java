import java.util.Scanner;

public class MinCostClimbingStairs {
    // 1. Recursive Top Down - O(2^n) Time Limit Exceeded

    public static int minCostClimbingStairs_Recursion(int[] cost) {
        int n = cost.length;
        return Math.min(minCost_Recursion(cost, n - 1), minCost_Recursion(cost, n - 2));
    }

    private static int minCost_Recursion(int[] cost, int n) {
        if (n < 0)
            return 0;

        if (n == 0 || n == 1)
            return cost[n];

        return cost[n] + Math.min(minCost_Recursion(cost, n - 1), minCost_Recursion(cost, n - 2));
    }

    // 2. Top Down Memoization - O(n)
    static int[] dp;

    public static int minCostClimbingStairs_TopDown(int[] cost) {
        int n = cost.length;
        dp = new int[n];

        return Math.min(minCost_TopDown(cost, n - 1), minCost_TopDown(cost, n - 2));
    }

    private static int minCost_TopDown(int[] cost, int n) {
        if (n < 0)
            return 0;

        if (n == 0 || n == 1)
            return cost[n];

        if (dp[n] != 0)
            return dp[n];

        dp[n] = cost[n] + Math.min(minCost_TopDown(cost, n - 1), minCost_TopDown(cost, n - 2));
        return dp[n];
    }

    // 3. Bottom up tabulation - O(n)
    public static int minCostClimbingStairs_BottomUp(int[] cost) {
        int n = cost.length;
        int[] dpArray = new int[n];

        for (int i = 0; i < n; i++) {
            if (i < 2)
                dpArray[i] = cost[i];
            else
                dpArray[i] = cost[i] + Math.min(dpArray[i - 1], dpArray[i - 2]);
        }

        return Math.min(dpArray[n - 1], dpArray[n - 2]);
    }

    // Bottom up computation - O(n) time, O(1) space
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];

        if (n <= 2)
            return Math.min(first, second);

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }

        return Math.min(first, second);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            cost[i] = scr.nextInt();
        }

        System.out.println(minCostClimbingStairs(cost));
        scr.close();
    }
}
