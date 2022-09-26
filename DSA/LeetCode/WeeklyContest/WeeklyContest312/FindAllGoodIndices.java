import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class FindAllGoodIndices {
    public static List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;

        int[] nonIncreasingCount = new int[n];
        Arrays.fill(nonIncreasingCount, 1);

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                nonIncreasingCount[i] = 1 + nonIncreasingCount[i - 1];
            }
        }

        int[] nonDecreasingCount = new int[n];
        Arrays.fill(nonDecreasingCount, 1);

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] >= nums[i]) {
                nonDecreasingCount[i] = 1 + nonDecreasingCount[i + 1];
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = k; i < n - k; i++) {
            if (nonIncreasingCount[i - 1] >= k && nonDecreasingCount[i + 1] >= k) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int k = scr.nextInt();

        System.out.println(goodIndices(nums, k));
        scr.close();
    }
}
