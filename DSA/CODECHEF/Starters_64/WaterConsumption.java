import java.util.Scanner;

public class WaterConsumption {
    private static String solve(String str) {
        int n = str.length();

        int mid = n / 2;
        int i = 0;
        while (i < mid) {
            if (str.charAt(i) != str.charAt(i + mid)) {
                return "NO";
            }
            i++;
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String str = scr.next();
            System.out.println(solve(str));

            t--;
        }

        scr.close();
    }
}