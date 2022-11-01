import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FindOriginalArrayFromDoubledArray {
    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        if (n % 2 != 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[n / 2];

        for (int i = 0; i < n; i++) {
            hm.put(changed[i], hm.getOrDefault(changed[i], 0) + 1);
        }

        Arrays.sort(changed);
        int j = 0;

        for (int x : changed) {
            if (hm.get(x) <= 0) {
                continue;
            }

            if (hm.getOrDefault(2 * x, 0) <= 0) {
                return new int[0];
            }

            ans[j++] = x;

            hm.put(x, hm.get(x) - 1);
            hm.put(2 * x, hm.get(2 * x) - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] changed = new int[n];

        for (int i = 0; i < n; i++) {
            changed[i] = scr.nextInt();
        }

        int[] res = findOriginalArray(changed);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

        System.out.println();
        scr.close();
    }
}
