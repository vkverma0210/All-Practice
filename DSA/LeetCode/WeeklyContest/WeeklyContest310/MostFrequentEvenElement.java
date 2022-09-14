import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class MostFrequentEvenElement {
    public static int mostFrequentEven(int[] nums) {
        SortedMap<Integer, Integer> sm = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                sm.put(nums[i], sm.getOrDefault(nums[i], 0) + 1);
            }
        }

        int counts = -1;
        int ans = -1;
        for (Integer s : sm.keySet()) {
            if (sm.get(s) > counts) {
                counts = sm.get(s);
                ans = s;
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

        System.out.println(mostFrequentEven(nums));

        scr.close();
    }
}
