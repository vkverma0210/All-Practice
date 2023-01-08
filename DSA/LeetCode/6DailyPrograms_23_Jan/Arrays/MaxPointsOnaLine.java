import java.util.Scanner;

public class MaxPointsOnaLine {
    public static int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2)
            return n;

        int ans = 2;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = 2;

                for (int k = j + 1; k < n; k++) {
                    int x = (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
                    int y = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);

                    if (x == y) {
                        temp++;
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
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = scr.nextInt();
            points[i][1] = scr.nextInt();
        }

        System.out.println(maxPoints(points));
        scr.close();
    }
}
