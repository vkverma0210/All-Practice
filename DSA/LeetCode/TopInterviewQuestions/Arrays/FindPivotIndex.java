import java.util.Scanner;

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        if (nums.length < 1)
            return -1;

        int rightSum = 0, leftSum = 0;

        for (int x : nums)
            rightSum += x;

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];

            if (rightSum == leftSum)
                return i;

            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(pivotIndex(nums));

        scr.close();
    }
}
