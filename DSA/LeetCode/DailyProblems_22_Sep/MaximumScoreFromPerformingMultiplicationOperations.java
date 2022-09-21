import java.util.Arrays;
import java.util.Scanner;

public class MaximumScoreFromPerformingMultiplicationOperations {
    private static int maximumScore_Helper(int[] nums, int numStart, int numEnd, int[] multipliers, int multStart,
            Integer[][] dp) {
        if (multStart == multipliers.length)
            return 0;

        if (dp[multStart][numStart] != null)
            return dp[multStart][numStart];

        // we have 2 option taking starting element of nums or ending of the nums so 2
        // option is created and taking maximum of both the answer
        int takingStart = multipliers[multStart] * nums[numStart]
                + maximumScore_Helper(nums, numStart + 1, numEnd, multipliers, multStart + 1, dp);
        int takingEnd = multipliers[multStart] * nums[numEnd]
                + maximumScore_Helper(nums, numStart, numEnd - 1, multipliers, multStart + 1, dp);

        return dp[multStart][numStart] = Math.max(takingStart, takingEnd);
    }

    public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;

        // calling recursive function to calculate the maximum Score with 2D dp
        return maximumScore_Helper(nums, 0, n - 1, multipliers, 0, new Integer[m][m]);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int m = scr.nextInt();
        int[] multipliers = new int[m];

        for (int i = 0; i < m; i++) {
            multipliers[i] = scr.nextInt();
        }

        System.out.println(maximumScore(nums, multipliers));

        scr.close();
    }
}