import java.util.Scanner;

public class MinimumAverageDifference {
    public static int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int res = 0;
        long min = Long.MAX_VALUE;
        long currSum = 0;
        for (int i = 0; i < n - 1; i++) {
            currSum += nums[i];
            sum -= nums[i];
            long diff = Math.abs(currSum / (i + 1) - sum / (nums.length - i - 1));

            if (diff < min) {
                min = diff;
                res = i;
            }
        }

        currSum += nums[nums.length - 1];
        if (currSum / nums.length < min) {
            res = nums.length - 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(minimumAverageDifference(nums));
        scr.close();
    }
}
