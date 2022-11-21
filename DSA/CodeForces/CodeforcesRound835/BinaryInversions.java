import java.util.Scanner;

public class BinaryInversions {
    private static long helper(int n, int[] arr) {
        long ans = 0, count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                ans += count;
            } else {
                count++;
            }
        }

        return ans;
    }

    private static long solve(int n, int[] arr) {
        int leftMost0 = -1, rightMost1 = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0 && leftMost0 == -1) {
                leftMost0 = i;
            } else if (arr[i] == 1) {
                rightMost1 = i;
            }
        }

        long ans = helper(n, arr);

        if (leftMost0 != -1) {
            int[] temp = arr;
            temp[leftMost0] = 1;
            ans = Math.max(ans, helper(n, temp));
        }

        if (rightMost1 != -1) {
            int[] temp = arr;
            temp[rightMost1] = 0;
            ans = Math.max(ans, helper(n, temp));
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
