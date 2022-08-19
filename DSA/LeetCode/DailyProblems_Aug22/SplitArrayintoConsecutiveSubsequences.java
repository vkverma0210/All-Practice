import java.util.HashMap;
import java.util.Scanner;

public class SplitArrayintoConsecutiveSubsequences {
    public static boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> availabilityMap = new HashMap<>();
        HashMap<Integer, Integer> vacancyMap = new HashMap<>();

        for (int i : nums) {
            availabilityMap.put(i, availabilityMap.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (availabilityMap.get(nums[i]) <= 0) {
                continue;
            } else if (vacancyMap.getOrDefault(nums[i], 0) > 0) {
                availabilityMap.put(nums[i], availabilityMap.getOrDefault(nums[i], 0) - 1);
                vacancyMap.put(nums[i], vacancyMap.getOrDefault(nums[i], 0) - 1);
                vacancyMap.put(nums[i] + 1, vacancyMap.getOrDefault(nums[i] + 1, 0) + 1);
            } else if (availabilityMap.getOrDefault(nums[i], 0) > 0 && availabilityMap.getOrDefault(nums[i] + 1, 0) > 0
                    && availabilityMap.getOrDefault(nums[i] + 2, 0) > 0) {
                availabilityMap.put(nums[i], availabilityMap.getOrDefault(nums[i], 0) - 1);
                availabilityMap.put(nums[i] + 1, availabilityMap.getOrDefault(nums[i] + 1, 0) - 1);
                availabilityMap.put(nums[i] + 2, availabilityMap.getOrDefault(nums[i] + 2, 0) - 1);

                vacancyMap.put(nums[i] + 3, vacancyMap.getOrDefault(nums[i] + 3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }

        System.out.println(isPossible(arr));

        scr.close();
    }
}
