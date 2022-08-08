import java.util.Scanner;

public class FactorialProblem {
    static int INT_MAX = 100000000;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int k = scr.nextInt();

            int ans = INT_MAX;
            int occurance = 0;

            for (int i = 2; i * i <= k; i++) {
                if (k % i == 0) {
                    occurance = 0;

                    while (k % i == 0) {
                        occurance++;
                        k = k / i;
                    }

                    // Find out the power of i in n! side by side
                    int count = 0;
                    long p = i;

                    while (p <= n) {
                        count += n / p;
                        p = p * i;
                    }

                    ans = Math.min(ans, count / occurance);
                }
            }

            // we may have a case when still a prime factor is left

            if (k > 1) {
                int count = 0;
                int p = k;

                while (p <= n) {
                    count += n / p;
                    p *= k;
                }

                ans = Math.min(ans, count);
            }

            if (ans == INT_MAX) {
                ans = 0;
            }

            System.out.println(ans);

            t--;
        }

        scr.close();
    }
}
