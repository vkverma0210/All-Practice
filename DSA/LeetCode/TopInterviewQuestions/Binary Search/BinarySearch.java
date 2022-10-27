import java.util.Scanner;

public class BinarySearch {
    public static int searchTarget(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start +  (end - start) / 2;

            if (target == nums[mid])
                return mid;

            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
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

        int target = scr.nextInt();

        System.out.println(searchTarget(nums, target));

        scr.close();
    }
}
