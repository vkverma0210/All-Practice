import java.util.HashMap;
import java.util.Scanner;

public class NumberOfUnequalTripletsInArray {
    public static int unequalTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((nums[i] != nums[j]) && (nums[j] != nums[k]) && (nums[i] != nums[k])) {
                        ans++;
                    }
                }
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

        System.out.println(unequalTriplets(nums));
        scr.close();
    }
}
