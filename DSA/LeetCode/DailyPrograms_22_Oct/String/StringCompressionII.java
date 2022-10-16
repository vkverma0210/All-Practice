import java.util.Scanner;

public class StringCompressionII {
    public static int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();

        if (k == n) {
            return 0;
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = n;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int m = 0; m <= k; m++) {
                if (m > 0) {
                    dp[i][m] = Math.min(dp[i][m], dp[i - 1][m - 1]);
                }

                int same = 0, diff = 0;

                for (int j = i; j >= 1; j--) {
                    if (s.charAt(i - 1) == s.charAt(j - 1)) {
                        same++;
                    } else {
                        diff++;
                    }

                    if (m - diff >= 0) {
                        dp[i][m] = Math.min((dp[i][m]), dp[j - 1][m - diff] + getCount(same));
                    }
                }
            }
        }

        return dp[n][k];
    }

    private static int getCount(int same) {
        return same == 1 ? 1 : same < 10 ? 2 : same < 100 ? 3 : 4;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        int k = scr.nextInt();
        System.out.println(getLengthOfOptimalCompression(s, k));

        scr.close();
    }
}
