import java.util.Scanner;

public class TwoDifferentPalindromes {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            long x = scr.nextLong();
            long y = scr.nextLong();

            if ((x % 2 != 0) && (y % 2 != 0)) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

            t--;
        }

        scr.close();
    }
}
