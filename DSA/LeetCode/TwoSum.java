import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer requiredNumber = (Integer) (target - nums[i]);

            if (hm.containsKey(requiredNumber)) {
                int[] ans = { hm.get(requiredNumber), i };
                return ans;
            }

            hm.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int target = scr.nextInt();

        int[] ans = new int[2];
        ans = twoSum(nums, target);

        for (int i = 0; i < 2; i++) {
            System.out.println(ans[i]);
        }

        scr.close();
    }
}
