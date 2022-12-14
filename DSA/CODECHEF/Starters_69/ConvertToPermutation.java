import java.util.Arrays;
import java.util.Scanner;

public class ConvertToPermutation {
    private static int solve(int[] arr, int n) {
        Arrays.sort(arr);
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[i - 1] > i) {
                return -1;
            } else {
                count += (i) - arr[i - 1];
            }
        }

        return count;
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
