import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int size = lis.size();

            if (size == 0 || (size > 0 && num > lis.get(size - 1))) {
                lis.add(num);
            } else {
                int insertIndex = binarySearch(lis, num);
                lis.set(insertIndex, num);
            }
        }

        return lis.size();
    }

    static int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int ans = lengthOfLIS(nums);

        System.out.println(ans);

        scr.close();
    }
}
