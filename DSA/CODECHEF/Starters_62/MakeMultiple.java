import java.util.Scanner;

public class MakeMultiple {
    public static String solve(int x, int y) {
        return ((x <= y / 2) || (x == y) ? "YES" : "NO");
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();

            System.out.println(solve(x, y));
            t--;
        }

        scr.close();
    }
}
