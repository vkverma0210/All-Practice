import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;

public class CardRemoval {
    private static int solve(int[] arr, int n) {
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int a : arr) {
            hs.put(a, hs.getOrDefault(a, 0) + 1);
        }

        int maxValueInMap = (Collections.max(hs.values()));

        if (n == maxValueInMap) {
            return 0;
        } else {
            return n - maxValueInMap;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scr.nextInt();
            }

            System.out.println(solve(arr, n));
            t--;
        }

        scr.close();
    }
}
