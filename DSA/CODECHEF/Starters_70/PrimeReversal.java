import java.util.Scanner;

public class PrimeReversal {
    private static String solve(int n, String a, String b) {
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == '1')
                count1++;
        }

        for (int i = 0; i < n; i++) {
            if (b.charAt(i) == '1')
                count2++;
        }

        if (count1 == count2) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String a = scr.next();
            String b = scr.next();

            System.out.println(solve(n, a, b));
            t--;
        }

        scr.close();
    }
}
