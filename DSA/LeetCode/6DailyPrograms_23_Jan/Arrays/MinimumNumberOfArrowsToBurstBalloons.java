import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int result = 1;
        int previous = 0;

        for (int current = 1; current < points.length; current++) {
            if (points[current][0] > points[previous][1]) {
                result++;

                previous = current;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = scr.nextInt();
            points[i][1] = scr.nextInt();
        }

        System.out.println(findMinArrowShots(points));
        scr.close();
    }
}
