import java.util.Arrays;
import java.util.Scanner;

public class DecodeWays {
    // 1. Recursion
    public static int numDecodings1(String s) {
        return s.length() == 0 ? 0 : numDecodings1_Helper(s, 0);
    }

    private static int numDecodings1_Helper(String s, int i) {
        int n = s.length();
        if (i == n) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        int res = numDecodings1_Helper(s, i + 1);

        if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += numDecodings1_Helper(s, i + 2);
        }

        return res;
    }

    // 2. Recursion + Memoization
    public static int numDecodings2(String s) {
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return s.length() == 0 ? 0 : numDecodings2_Helper(s, 0, memo);
    }

    private static int numDecodings2_Helper(String s, int i, int[] memo) {
        int n = s.length();
        if (i == n) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int res = numDecodings2_Helper(s, i + 1, memo);

        if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += numDecodings2_Helper(s, i + 2, memo);
        }

        return memo[i] = res;
    }

    // 3. DP O(n) space and time
    public static int numDecodings3(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {

                dp[i] = dp[i + 1];

                if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }

    // 4. DP constant space
    public static int numDecodings4(String s) {
        int n = s.length();
        int dp1 = 1;
        int dp2 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int dp = s.charAt(i) == '0' ? 0 : dp1;

            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                dp += dp2;
            }

            dp2 = dp1;
            dp1 = dp;

        }

        return dp1;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();

        System.out.println(numDecodings1(s));
        System.out.println(numDecodings2(s));
        System.out.println(numDecodings3(s));
        System.out.println(numDecodings4(s));
        scr.close();
    }
}
