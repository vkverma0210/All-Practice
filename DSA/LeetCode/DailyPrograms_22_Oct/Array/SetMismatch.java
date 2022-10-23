import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;

        long sum = (n * (n + 1)) / 2;

        for (int num : nums) {
            if (set.contains(num)) {
                duplicate = num;
            }

            sum -= num;
            set.add(num);
        }

        ans[0] = duplicate;
        ans[1] = (int) sum + duplicate;

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int[] ans = findErrorNums(nums);

        System.out.println(ans[0] + " " + ans[1]);

        scr.close();
    }
}
