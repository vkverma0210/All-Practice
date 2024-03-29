import java.util.Scanner;

public class DominoAndTrominoTiling {
    public static int numTilings(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = ((2 * dp[i - 1]) % mod + dp[i - 3] % mod) % mod;
        }

        return dp[n] % mod;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        System.out.println(numTilings(n));
        scr.close();
    }
}