import java.util.Scanner;

public class SortedSubstrings {
    public static int solve(int n, String str) {
        int i = 1, count = 0;

        while (i < n) {
            if (str.charAt(i) == '0' && str.charAt(i - 1) == '1') {
                count++;
            }

            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String str = scr.next();

            System.out.println(solve(n, str));
            t--;
        }

        scr.close();
    }
}
