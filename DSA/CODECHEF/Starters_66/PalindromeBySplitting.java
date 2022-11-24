import java.util.Scanner;

public class PalindromeBySplitting {
    public static int solve(int n, int[] array) {
        int start = 0, end = n - 1;
        int ans = 0;

        while (start <= end) {
            if (array[start] == array[end]) {
                start++;
                end--;
            } else if (array[start] < array[end]) {
                array[end] -= array[start];
                start++;
                ans++;
            } else {
                array[start] -= array[end];
                end--;
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
