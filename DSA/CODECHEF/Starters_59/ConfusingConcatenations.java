import java.util.Scanner;

public class ConfusingConcatenations {
    public static void solve(int n, int[] c) {
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (c[i] > c[maxIdx]) {
                maxIdx = i;
            }
        }

        if (maxIdx != 0) {
            StringBuilder ans1 = new StringBuilder("");
            StringBuilder ans2 = new StringBuilder("");

            System.out.println(maxIdx);

            for (int i = 0; i < maxIdx; i++) {
                ans1.append(Integer.toString(c[i]) + " ");
            }

            System.out.println(ans1.toString());
            System.out.println(n - maxIdx);

            for (int i = maxIdx; i < n; i++) {
                ans2.append(Integer.toString(c[i]) + " ");
            }

            System.out.println(ans2.toString());
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int c[] = new int[n];

            for (int i = 0; i < n; i++) {
                c[i] = scr.nextInt();
            }

            solve(n, c);
            t--;
        }

        scr.close();
    }
}
