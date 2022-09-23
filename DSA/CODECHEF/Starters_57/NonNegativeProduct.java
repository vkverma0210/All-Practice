import java.util.Scanner;

public class NonNegativeProduct {
    public static int solve(int[] arr, int n) {
        int count = 0;

        for (int x : arr) {
            if (x == 0) {
                return 0;
            } else if (x < 0) {
                count++;
            }
        }

        if (count % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int[] x = new int[n];

            for (int i = 0; i < n; i++) {
                x[i] = scr.nextInt();
            }

            System.out.println(solve(x, n));
            t--;
        }

        scr.close();
    }
}
