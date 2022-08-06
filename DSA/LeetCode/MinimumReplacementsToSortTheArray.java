import java.util.Scanner;

public class MinimumReplacementsToSortTheArray {
    public static long minimumReplacement(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int prev = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int noOfTimes = nums[i] / prev;

            if (nums[i] % prev != 0)
                noOfTimes++;

            if (nums[i] % prev != 0)
                prev = nums[i] / noOfTimes;

            ans += noOfTimes - 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        long ans = minimumReplacement(nums);

        System.out.println(ans);

        scr.close();
    }
}
