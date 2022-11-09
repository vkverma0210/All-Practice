import java.util.HashSet;
import java.util.Scanner;

public class PrimeFactorDivision {
    private static HashSet<Long> prime(long n) {
        HashSet<Long> dp = new HashSet<>();

        while (n % 2 == 0) {
            dp.add((long) 2);
            n /= 2;
        }

        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                dp.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            dp.add(n);
        }

        return dp;
    }

    private static String solve(long a, long b) {
        HashSet<Long> dp = prime(b);

        for (Long d : dp) {
            if (a % d != 0) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            long a = scr.nextLong();
            long b = scr.nextLong();

            System.out.println(solve(a, b));

            t--;
        }

        scr.close();
    }
}
