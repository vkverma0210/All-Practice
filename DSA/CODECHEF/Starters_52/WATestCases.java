import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class WATestCases {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {

            int n = scr.nextInt();
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                b[i] = scr.nextInt();
            }

            String c = scr.next();

            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (c.charAt(i) == '0') {
                    ans = Math.min(ans, b[i]);
                }
            }

            System.out.println(ans);

            t--;
        }

        scr.close();
    }
}
