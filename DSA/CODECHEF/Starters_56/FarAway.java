import java.util.Scanner;

public class FarAway {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int m = scr.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scr.nextInt();
            }

            long ans = 0;

            for (int x : arr) {
                ans += Math.max(Math.abs(x - 1), Math.abs(x - m));
            }

            System.out.println(ans);

            t--;
        }

        scr.close();
    }
}
