import java.util.Scanner;

public class ReynaAndString {
    private static int solve(int n, int p, String str) {
        int count = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 26 - (str.charAt(i) - 'A');
            count += dp[i];
        }

        Arrays.sort(dp);
        int ans = 0;

        for (int d : dp) {
            if (count - d > p) {
                count -= d;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int p = scr.nextInt();
            String str = scr.next();

            System.out.println(solve(n, p, str));
            t--;
        }

        scr.close();
    }
}