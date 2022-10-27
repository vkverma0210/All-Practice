import java.util.Scanner;

public class RunningSumof1dArray {
    public static int[] runningSum(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        ans[0] = nums[0];

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + nums[i];
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

        int[] res = runningSum(nums);

        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
        
        scr.close();
    }
}
