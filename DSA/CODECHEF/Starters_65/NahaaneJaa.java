import java.util.Scanner;

public class NahaaneJaa {
    public static String solve(int n, long[] arr, long k) {
        if (n == 1) {
            if (arr[0] == k) {
                return "YES";
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            long k = scr.nextLong();
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scr.nextLong();
            }

            System.out.println(solve(n, arr, k));
            t--;
        }

        scr.close();
    }
}
