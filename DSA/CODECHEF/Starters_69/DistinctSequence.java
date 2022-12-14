import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DistinctSequence {
    private static void solve(String str, int n) {
        int count1 = 0;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (int i = 0; i < 2 * n; i++) {
            if (str.charAt(i) == '1') {
                count1++;
                l1.add(i + 1);
            } else {
                l2.add(i + 1);
            }
        }

        int count2 = 2 * n - count1;

        if (count1 == 0 || count2 == 0) {
            System.out.println(-1);
        } else {
            int j = 0;
            int k = l1.size();
            if (k >= n) {
                while (j < n) {
                    System.out.print(l1.get(j) + " ");
                    j++;
                }
            } else {
                while (j < n) {
                    System.out.print(l2.get(j) + " ");
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String str = scr.next();

            solve(str, n);
            System.out.println();
            t--;
        }

        scr.close();
    }
}
