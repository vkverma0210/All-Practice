import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Candies {
    public static String solve(int n, int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer val : hm.values()) {
            if (val > 2) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int[] arr = new int[2 * n];

            for (int i = 0; i < 2 * n; i++) {
                arr[i] = scr.nextInt();
            }

            System.out.println(solve(2 * n, arr));
            t--;
        }

        scr.close();
    }
}
