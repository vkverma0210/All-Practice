import java.util.Scanner;

public class ExpensiveSteps {
    private static long solve(long n, long k) {
        long ans = 0;
        ans = n * (n - 1) / 2;

        if (k < n / 2) {
            long x1 = (n - (2 * k));
            ans -= (x1 * (x1 - 1)) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            long n = scr.nextLong();
            long k = scr.nextLong();

            System.out.println(solve(n, k));
            t--;
        }

        scr.close();
    }
}
