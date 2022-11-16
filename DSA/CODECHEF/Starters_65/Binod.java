import java.util.Scanner;

public class Binod {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int q = scr.nextInt();
            int[][] arr = new int[64][n];
            for (int i = 0; i < n; i++) {
                long x = scr.nextLong();

                for (int j = 0; j < 64; j++) {
                    arr[j][i] = (int) (x % 2);
                    x /= 2;
                }
            }

            for (int i = 0; i < 64; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    count += arr[i][j];
                    arr[i][j] = count;
                }
            }

            while (q != 0) {
                int k = scr.nextInt();
                int l1 = scr.nextInt();
                int r1 = scr.nextInt();
                int l2 = scr.nextInt();
                int r2 = scr.nextInt();

                l1--;
                l2--;
                r1--;
                r2--;

                int total1 = r1 - l1 + 1;
                int total2 = r2 - l2 + 1;
                int totalf1, totalf2;

                if (l1 == 0) {
                    totalf1 = arr[k][r1];
                } else {
                    totalf1 = arr[k][r1] - arr[k][l1 - 1];
                }

                if (l2 == 0) {
                    totalf2 = arr[k][r2];
                } else {
                    totalf2 = arr[k][r2] - arr[k][l2 - 1];
                }

                long ans = (long) (total1 - totalf1) * (long) (totalf2) + (long) (totalf1) * (long) (total2 - totalf2);
                System.out.println(ans);

                q--;
            }

            t--;
        }

        scr.close();
    }
}
