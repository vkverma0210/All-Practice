import java.util.Scanner;

public class LuigiAndUniformity {
    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static int findGCD(int arr[], int n) {
        int result = arr[0];
        for (int element : arr) {
            result = gcd(result, element);

            if (result == 1) {
                return 1;
            }
        }

        return result;
    }

    private static int solve(int n, int[] arr) {
        int gcd = findGCD(arr, n);
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == gcd) {
                count++;
            }
        }

        return n - count;
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
