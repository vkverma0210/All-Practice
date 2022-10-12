import java.util.Scanner;

public class YetAnotherPalindromeProblem {
    private static int solve(int[] arr, int n) {
        int i = 0, j = n - 1;
        int count = 0;
        while (i <= j) {
            if (arr[i] > arr[j]) {
                return -1;
            } else {
                int temp = arr[j] - arr[i];
                count = Math.max(count, temp);
                i++;
                j--;
            }
        }

        return count;
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
