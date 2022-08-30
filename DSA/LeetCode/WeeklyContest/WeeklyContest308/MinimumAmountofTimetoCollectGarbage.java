import java.util.Scanner;

public class MinimumAmountofTimetoCollectGarbage {
    public static int garbageCollection(String[] garbage, int[] travel) {
        int[] prefix = new int[travel.length];
        prefix[0] = travel[0];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = travel[i] + prefix[i - 1];
        }

        int ans = 0;
        int g = 0;
        int m = 0;
        int p = 0;

        for (int i = 0; i < garbage.length; i++) {
            String current = garbage[i];
            for (char c : current.toCharArray()) {
                if (c == 'M')
                    m = i;
                if (c == 'P')
                    p = i;
                if (c == 'G')
                    g = i;
            }

            ans += current.length();
        }

        if (g >= 1)
            ans += prefix[g - 1];

        if (p >= 1)
            ans += prefix[p - 1];

        if (m >= 1)
            ans += prefix[m - 1];

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        String[] garbage = new String[n];

        for (int i = 0; i < n; i++) {
            garbage[i] = scr.next();
        }

        int m = scr.nextInt();

        int[] travel = new int[m];

        for (int i = 0; i < m; i++) {
            travel[i] = scr.nextInt();
        }

        System.out.println(garbageCollection(garbage, travel));

        scr.close();
    }
}
