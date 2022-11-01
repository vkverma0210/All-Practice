import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> modSet = new HashSet<>();
        int currSum = 0, prevSum = 0;

        for (int n : nums) {
            currSum += n;
            if (modSet.contains(currSum % k)) {
                return true;
            }

            currSum %= k;
            modSet.add(prevSum);
            prevSum = currSum;
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

        int k = scr.nextInt();
        System.out.println(checkSubarraySum(nums, k));

        scr.close();
    }
}
