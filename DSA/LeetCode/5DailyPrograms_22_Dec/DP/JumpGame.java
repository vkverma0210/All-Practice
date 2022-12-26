import java.util.Scanner;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int reachable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reachable)
                return false;

            reachable = Math.max(reachable, i + nums[i]);
            System.out.println(reachable);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(canJump(nums));
        scr.close();
    }
}
