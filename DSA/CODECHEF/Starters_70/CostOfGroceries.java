import java.util.Scanner;

public class CostOfGroceries {
    private static int solve(int n, int x, int[] a, int[] b) {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] >= x)
                ans += b[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int x = scr.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scr.nextInt();
            }

            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scr.nextInt();
            }

            System.out.println(solve(n, x, a, b));
            t--;
        }

        scr.close();
    }
}
