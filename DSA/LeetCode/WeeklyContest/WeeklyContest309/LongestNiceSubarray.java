import java.util.Scanner;

public class LongestNiceSubarray {
    public static int longestNiceSubarray(int[] nums) {
        int AND = 0, j = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            while ((AND & nums[i]) > 0) {
                AND ^= nums[j++];
            }

            AND |= nums[i];
            res = Math.max(res, i - j + 1);
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

        System.out.println(longestNiceSubarray(nums));

        scr.close();
    }
}
