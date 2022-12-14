import java.util.Scanner;

public class HouseRobber2 {
    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int prev1 = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            pick += prev2;

            int notPick = 0 + prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
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

        System.out.println(rob(nums));
        scr.close();
    }
}
