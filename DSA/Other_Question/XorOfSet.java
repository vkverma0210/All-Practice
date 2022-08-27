import java.util.Scanner;

public class XorOfSet {
    public static long solve(int[] A, int B) {
        int n = A.length;

        int x = n / B;
        long ans = 0;

        for (int i = 0; i < n; i += x) {
            long temp = 0;
            for (int j = 0; j < x; j++) {
                temp = temp | A[i + j];
            }

            ans += temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String val = scr.nextLine();
        String[] arr = val.split("\\s+");

        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }

        int b = scr.nextInt();

        System.out.println(solve(a, b));

        scr.close();
    }
}
