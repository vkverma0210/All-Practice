import java.util.Scanner;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int j = 0, n = nums.length;

        if (nums == null || n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < n; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        moveZeroes(nums);

        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }

        scr.close();
    }
}
