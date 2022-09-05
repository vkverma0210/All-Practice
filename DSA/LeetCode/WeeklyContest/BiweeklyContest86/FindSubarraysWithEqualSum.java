import java.util.HashSet;
import java.util.Scanner;

public class FindSubarraysWithEqualSum {
    public static boolean findSubarrays(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 1; i < nums.length; i++) {
            hs.add(nums[i] + nums[i - 1]);

            if (hs.size() == (nums.length - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(findSubarrays(nums));

        scr.close();
    }
}
