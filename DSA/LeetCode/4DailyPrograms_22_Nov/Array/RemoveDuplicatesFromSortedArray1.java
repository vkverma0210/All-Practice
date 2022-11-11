import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray1 {
    public static int removeDuplicates(int[] nums) {
        int i = 1, j = 0;

        while (i < nums.length) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }

            i++;
        }

        return j + 1;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }
        int ans = removeDuplicates(nums);

        for (int i = 0; i < ans; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
        scr.close();
    }
}
