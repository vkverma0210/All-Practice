import java.util.Scanner;

public class DistinctColors {
    private static int solve(int n, int[] arr) {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scr.nextInt();
            }
            System.out.println(solve(n, arr));

            t--;
        }

        scr.close();
    }
}
