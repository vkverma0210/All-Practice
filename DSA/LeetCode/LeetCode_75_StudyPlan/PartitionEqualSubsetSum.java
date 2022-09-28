import java.util.Arrays;
import java.util.Scanner;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 == 1) {
            return false;
        }

        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(canPartition(nums));
        scr.close();
    }
}
