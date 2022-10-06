import java.util.Scanner;

public class MaximumSubarray {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scr.nextInt();
            }

            int m = scr.nextInt();
            int b[] = new int[m];

            for (int i = 0; i < m; i++) {
                b[i] = scr.nextInt();
            }

            long maxSum = 0;
            long currSum = 0;

            for (int i = 0; i < n; i++) {
                currSum += a[i];
                maxSum = Math.max(maxSum, currSum);
            }

            currSum = 0;
            for (int i = n - 1; i >= 0; i--) {
                currSum += a[i];
                maxSum = Math.max(maxSum, currSum);
            }

            for (int i = 0; i < m; i++) {
                if (b[i] > 0) {
                    maxSum += b[i];
                }
            }

            System.out.println(maxSum);

            t--;
        }

        scr.close();
    }
}
