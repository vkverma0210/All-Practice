import java.util.Scanner;

public class JustLikeMob {
    public static String solve(long n, long m, long k, long x) {
        long notMob = n * (k - 1);
        long mob = (n + m);
        long day = notMob + mob;

        long rem = x % day;

        if ((rem > notMob && rem <= day) || (rem == 0)) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            long n = scr.nextLong();
            long m = scr.nextLong();
            long k = scr.nextLong();
            long x = scr.nextLong();

            System.out.println(solve(n, m, k, x));
            t--;
        }

        scr.close();
    }
}
