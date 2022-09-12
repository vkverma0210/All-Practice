import java.util.Scanner;

public class NumberofWaystoReachaPositionAfterExactly_k_Steps {
    static int mod = 1000000007;

    public static int numberOfWays(int a, int b, int k) {
        if ((a - b - k) % 2 != 0)
            return 0;

        if (Math.abs(a - b) > k)
            return 0;

        long res = 1L;

        for (int i = 0; i < (b - a + k) / 2; i++) {
            res = res * (k - i) % mod;
            res = res * inv(i + 1) % mod;
        }

        return (int) res;
    }

    private static long inv(long a) {
        if (a == 1)
            return 1;

        return (mod - mod / a) * inv(mod % a) % mod;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int startPos = scr.nextInt();
        int endPos = scr.nextInt();
        int k = scr.nextInt();

        System.out.println(numberOfWays(startPos, endPos, k));

        scr.close();
    }
}
