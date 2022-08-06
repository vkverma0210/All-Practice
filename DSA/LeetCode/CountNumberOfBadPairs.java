import java.util.HashMap;
import java.util.Scanner;

public class CountNumberOfBadPairs {
    public static long countBadPairs(int[] nums) {
        long count = 0;
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int prev = mp.getOrDefault(i - nums[i], 0);

            count += prev;

            mp.put(i - nums[i], prev + 1);
        }

        long total = 1L * n * (n - 1) / 2;
        return total - count;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        long ans = countBadPairs(nums);

        System.out.println(ans);

        scr.close();
    }
}
