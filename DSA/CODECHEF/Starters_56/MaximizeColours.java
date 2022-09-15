import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximizeColours {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();
            int z = scr.nextInt();
            int ans = 0;

            if (x > 0) {
                ans += 1;
                x--;
            }

            if (y > 0) {
                ans += 1;
                y--;
            }

            if (z > 0) {
                ans += 1;
                z--;
            }

            Integer[] arr = new Integer[3];

            arr[0] = x;
            arr[1] = y;
            arr[2] = z;
            Arrays.sort(arr, Collections.reverseOrder());

            if (arr[0] > 0 && arr[1] > 0) {
                arr[0]--;
                arr[1]--;
                ans++;
            }

            if (arr[0] > 0 && arr[2] > 0) {
                arr[0]--;
                arr[2]--;
                ans++;
            }

            if (arr[1] > 0 && arr[2] > 0) {
                arr[1]--;
                arr[2]--;
                ans++;
            }

            System.out.println(ans);
            t--;
        }

        scr.close();
    }
}
