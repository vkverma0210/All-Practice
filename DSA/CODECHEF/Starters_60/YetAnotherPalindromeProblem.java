import java.util.Scanner;

public class YetAnotherPalindromeProblem {
    private static int solve(int[] arr, int n) {
        int[] ans = new int[n / 2];
        int start = 0, end = n - 1;

        for (int i = 0; i < n / 2; i++) {
            if (arr[start + i] == arr[end - i]) {
                ans[i] = 0;
            } else if (arr[start + i] < arr[end - i]) {
                ans[i] = arr[end - i] - arr[start + i];
            } else {
                ans[0] = -1;
                break;
            }

            if (i != 0 && ans[i - 1] < ans[i]) {
                ans[0] = -1;
                break;
            }
        }

        return ans[0];
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

            System.out.println(solve(arr, n));

            t--;
        }

        scr.close();
    }
}
