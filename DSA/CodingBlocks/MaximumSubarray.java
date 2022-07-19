import java.util.Scanner;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int maxsofar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], nums[i] + currentMax);
            maxsofar = Math.max(currentMax, maxsofar);
        }

        return maxsofar;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int ans = maxSubArray(nums);

        System.out.println(ans);

        scr.close();

    }
}
