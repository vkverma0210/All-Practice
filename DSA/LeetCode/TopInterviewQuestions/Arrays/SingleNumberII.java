import java.util.Scanner;

public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            twos |= ones & nums[i];
            ones ^= nums[i];
            threes = ones & twos;

            ones &= ~threes;
            twos &= ~threes;
        }

        return ones;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(singleNumber(nums));

        scr.close();
    }
}
