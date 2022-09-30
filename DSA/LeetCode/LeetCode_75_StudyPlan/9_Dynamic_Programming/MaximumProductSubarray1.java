import java.util.Scanner;

public class MaximumProductSubarray1 {
    public static int maxProduct(int[] nums) {
        int currProduct = nums[0];
        int maxProductSoFar = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currProduct;
            currProduct = Math.max(nums[i], Math.max(currProduct * nums[i], nums[i] * minEndingHere));
            minEndingHere = Math.min(nums[i], Math.min(temp * nums[i], nums[i] * minEndingHere));
            maxProductSoFar = Math.max(currProduct, maxProductSoFar);
        }

        return maxProductSoFar;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(maxProduct(nums));
        scr.close();
    }
}
