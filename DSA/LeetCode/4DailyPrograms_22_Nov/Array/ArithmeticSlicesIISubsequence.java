import java.util.HashMap;
import java.util.Scanner;

public class ArithmeticSlicesIISubsequence {
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                if (diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE)
                    continue;

                int d = (int) diff;
                int count1 = map[i].getOrDefault(d, 0);
                int count2 = map[j].getOrDefault(d, 0);
                ans += count2;

                map[i].put(d, count2 + count1 + 1);
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

        System.out.println(numberOfArithmeticSlices(nums));

        scr.close();
    }
}
