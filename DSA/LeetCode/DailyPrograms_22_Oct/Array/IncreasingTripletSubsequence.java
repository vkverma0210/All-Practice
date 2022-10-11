import java.util.Scanner;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n <= big) {
                big = n;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(increasingTriplet(nums));

        scr.close();
    }
}
