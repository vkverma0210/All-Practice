import java.util.Scanner;

import java.util.Scanner;

public class BurstBalloons {
    private static int burstBalloons(int[] nums, int beg, int end, Integer[][] dp) {
        if (beg < 0 || end < 0 || beg >= nums.length || end >= nums.length)
            return 0;

        if (dp[beg][end] != null)
            return dp[beg][end];

        int max = 0;

        int prev = beg - 1 >= 0 ? nums[beg - 1] : 1;
        int next = end + 1 < nums.length ? nums[end + 1] : 1;

        for (int i = beg; i <= end; i++) {
            max = Math.max(max, burstBalloons(nums, beg, i - 1, dp) + (prev * nums[i] * next)
                    + burstBalloons(nums, i + 1, end, dp));

        }

        return dp[beg][end] = max;
    }

    public static int maxCoins(int[] nums) {
        return burstBalloons(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(maxCoins(nums));

        scr.close();
    }
}
