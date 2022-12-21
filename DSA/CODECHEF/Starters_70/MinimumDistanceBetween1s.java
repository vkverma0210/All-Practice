import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumDistanceBetween1s {
    private static int solve(int n, String a) {
        int count = 0;
        int mini = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == '1') {
                list.add(i);
            }
        }

        int l = list.size();
        int start = list.get(l - 1);

        for (int i = 0; i < l; i++) {
            if ((start - list.get(i)) % 2 == 1) {
                return 1;
            }
        }

        return 2;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String a = scr.next();

            System.out.println(solve(n, a));
            t--;
        }

        scr.close();
    }
}
