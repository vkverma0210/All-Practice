import java.util.Scanner;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;

        floodFillHelper(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private static void floodFillHelper(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }

        image[sr][sc] = newColor;

        floodFillHelper(image, sr + 1, sc, color, newColor);
        floodFillHelper(image, sr - 1, sc, color, newColor);
        floodFillHelper(image, sr, sc + 1, color, newColor);
        floodFillHelper(image, sr, sc - 1, color, newColor);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int m = scr.nextInt();

        int[][] image = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                image[i][j] = scr.nextInt();
            }
        }

        int sr = scr.nextInt();
        int sc = scr.nextInt();
        int color = scr.nextInt();

        int[][] ans = floodFill(image, sr, sc, color);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        scr.close();
    }
}
