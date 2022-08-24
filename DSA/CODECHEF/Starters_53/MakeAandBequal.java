import java.util.Scanner;

public class MakeAandBequal {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {

            int n = scr.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scr.nextInt();
            }

            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scr.nextInt();
            }

            int diff = 0;
            long ans = 0;

            for (int i = 0; i < n; i++) {
                diff += a[i] - b[i];
                ans += Math.abs(a[i] - b[i]);
            }

            if (diff != 0)
                System.out.println(-1);
            else
                System.out.println(ans / 2);

            t--;
        }

        scr.close();
    }
}
