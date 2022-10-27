import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MakeArrayZeroBySubtractingEqualAmounts {

    public static int minimumOperations(int[] nums) {
        Arrays.sort(nums);

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];

                for (int j = i; j < nums.length; j++) {
                    nums[j] = nums[j] - temp;
                }

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int ans = minimumOperations(nums);

        System.out.println(ans);

        scr.close();
    }
}