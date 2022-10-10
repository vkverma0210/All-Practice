import java.util.Arrays;
import java.util.Scanner;

public class MakeAEqualtoB {
    private static int solve(int[] a, int[] b, int n) {
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                count1++;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int count = 1, i = 0;

        while (i < n) {
            if (a[i] != b[i]) {
                count++;
            }
            i++;
        }

        if (count < count1) {
            return count;
        } else {
            return count1;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scr.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = scr.nextInt();
            }

            System.out.println(solve(a, b, n));
            t--;
        }
        scr.close();
    }
}
