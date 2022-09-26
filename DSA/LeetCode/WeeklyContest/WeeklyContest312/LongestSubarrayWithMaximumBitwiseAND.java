import java.util.Scanner;

public class LongestSubarrayWithMaximumBitwiseAND {
    public static int longestSubarray(int[] nums) {
        int result = 0, length = 0, max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num == max) {
                length++;
            } else {
                length = 0;
            }

            result = Math.max(result, length);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(longestSubarray(nums));
        scr.close();
    }
}
