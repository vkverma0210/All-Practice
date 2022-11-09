import java.util.Scanner;

public class RangeAssignNumberOfDistinctElementsMinimize {
    private static String solve(int n, long[] arr) {
        int i = 0, j = n - 1;
        int count = 0;
        while (i < j) {
            if (count >= 2) {
                return "NO";
            }

            if (arr[i] == arr[j]) {
                return "YES";
            }

            count++;
            j--;
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            long[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scr.nextInt();
            }
            System.out.println(solve(n, arr));

            t--;
        }

        scr.close();
    }
}
