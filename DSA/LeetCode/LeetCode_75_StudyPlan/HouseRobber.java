import java.util.Arrays;
import java.util.Scanner;

public class HouseRobber {
    // 1. recursive (top - down)
    public static int rob1(int[] nums) {
        return rob1Helper(nums, nums.length - 1);
    }

    private static int rob1Helper(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }

        return Math.max(rob1Helper(nums, i - 2) + nums[i], rob1Helper(nums, i - 1));
    }

    // 2. recursive + memo (top - down)
    static int[] memo1;

    public static int rob2(int[] nums) {
        memo1 = new int[nums.length + 1];
        Arrays.fill(memo1, -1);
        return rob2Helper(nums, nums.length - 1);
    }

    private static int rob2Helper(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }

        if (memo1[i] >= 0) {
            return memo1[i];
        }

        int res = Math.max(rob2Helper(nums, i - 2) + nums[i], rob2Helper(nums, i - 1));
        memo1[i] = res;
        return res;
    }

    // 3. Iterative + memo (bottom - up)
    public static int rob3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] memo2 = new int[nums.length + 1];
        memo2[0] = 0;
        memo2[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo2[i + 1] = Math.max(memo2[i], memo2[i - 1] + val);
        }

        return memo2[nums.length];
    }

    // 4. Iterative + 2 variable (bottom - up)
    public static int rob4(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(rob1(nums));
        System.out.println(rob2(nums));
        System.out.println(rob3(nums));
        System.out.println(rob4(nums));
        scr.close();
    }
}
