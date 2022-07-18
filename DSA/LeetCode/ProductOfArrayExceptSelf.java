import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length];

        int currProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = currProduct;
            currProduct = currProduct * nums[i];
        }

        currProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= currProduct;
            currProduct *= nums[i];
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

        int[] ans = new int[n];
        ans = productExceptSelf(nums);

        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }

        scr.close();
    }
}
