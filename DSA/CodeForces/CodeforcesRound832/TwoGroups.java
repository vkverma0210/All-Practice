import java.util.Scanner;

public class TwoGroups {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scr.nextLong();
            }

            long s1 = 0, s2 = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] < 0) {
                    s2 += arr[i];
                } else {
                    s1 += arr[i];
                }
            }

            long ans = Math.abs(Math.abs(s1) - Math.abs(s2));
            System.out.println(ans);
            t--;
        }

        scr.close();
    }
}
