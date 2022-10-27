import java.util.Scanner;

public class ImageOverlap {
    public static int largestOverlap(int[][] img1, int[][] img2) {
        int ans = 0, n = img1.length, lim = n + n - 1;

        int[][] t = new int[n + n + n - 2][n + n + n - 2];

        for (int i = 0, r = n - 1; i != n; i++, r++) {
            for (int j = 0, c = n - 1; j != n; j++, c++) {
                t[r][c] = img1[i][j];
            }
        }

        for (int y = 0; y != lim; y++) {
            for (int x = 0; x != lim; x++) {
                int temp = 0;

                for (int i = 0, r = y; i != n; i++, r++) {
                    for (int j = 0, c = x; j != n; j++, c++) {
                        temp += img2[i][j] & t[r][c];
                    }
                }

                if (temp > ans) {
                    ans = temp;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[][] img1 = new int[n][n];
        int[][] img2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                img1[i][j] = scr.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                img2[i][j] = scr.nextInt();
            }
        }

        System.out.println(largestOverlap(img1, img2));

        scr.close();
    }
}
