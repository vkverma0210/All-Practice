import java.util.Scanner;

public class TourOfKing {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int m = scr.nextInt();

            System.out.println((n * 5) + (m * 7));
            t--;
        }

        scr.close();
    }
}
