import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfPairsSatisfyingInequality {
    public static long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        List<Integer> diffList = new ArrayList<>();
        long res = 0;

        for (int i = 0; i < n; i++) {
            int currDiff = nums1[i] - nums2[i];
            int target = currDiff + diff;
            res += countSmallerEqual(diffList, target);
            diffList.add((int) countSmallerEqual(diffList, currDiff), currDiff);
        }

        return res;
    }

    private static long countSmallerEqual(List<Integer> diffList, int target) {
        int left = 0, right = diffList.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (diffList.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (long) left;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums1 = new int[n];

        for (int i = 0; i < n; i++) {
            nums1[i] = scr.nextInt();
        }

        int[] nums2 = new int[n];

        for (int i = 0; i < n; i++) {
            nums2[i] = scr.nextInt();
        }
        int diff = scr.nextInt();

        System.out.println(numberOfPairs(nums1, nums2, diff));

        scr.close();
    }
}
