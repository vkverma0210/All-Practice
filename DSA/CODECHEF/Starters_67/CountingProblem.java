import java.util.HashMap;
import java.util.Scanner;

public class CountingProblem {
    private static String solve(int[] arr, int n) {
        int countOdd = 0;

        for (int a : arr) {
            if (a % 2 != 0) {
                countOdd++;
            }
        }

        if (countOdd != 0 && countOdd % 2 == 0) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int[] arr = new int[n];

            int count = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = scr.nextInt();
            }

            System.out.println(solve(arr, n));
            t--;
        }

        scr.close();
    }
}
