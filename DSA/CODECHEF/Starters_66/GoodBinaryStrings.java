import java.util.Scanner;

public class GoodBinaryStrings {
    public static int solve(String str) {
        int n = str.length();
        return "NO";

    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            String str = scr.next();

            System.out.println(solve(str));
            t--;
        }

        scr.close();
    }
}
