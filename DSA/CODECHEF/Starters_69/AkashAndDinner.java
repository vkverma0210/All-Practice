import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AkashAndDinner {
    private static long solve(int[] arr1, int[] arr2, int n, int k) {
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hs.containsKey(arr1[i])) {
                if (hs.get(arr1[i]) > arr2[i]) {
                    hs.put(arr1[i], arr2[i]);
                }
            } else {
                hs.put(arr1[i], arr2[i]);
            }
        }

        Integer[] temp = hs.values().toArray(new Integer[0]);

        Arrays.sort(temp);

        if (temp.length < k) {
            return -1;
        }

        long count = 0;
        for (int i = 0; i < k; i++) {
            count += temp[i];
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int k = scr.nextInt();

            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = scr.nextInt();
            }

            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr2[i] = scr.nextInt();
            }

            System.out.println(solve(arr1, arr2, n, k));
            t--;
        }

        scr.close();
    }
}
