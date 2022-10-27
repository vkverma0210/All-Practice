import java.util.Scanner;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }

        return xor;
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
