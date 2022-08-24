import java.util.Scanner;

public class Weights {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {

            int w = scr.nextInt();
            int x = scr.nextInt();
            int y = scr.nextInt();
            int z = scr.nextInt();

            if (w == x) {
                System.out.println("YES");
            } else if (w == y) {
                System.out.println("YES");
            } else if (w == z) {
                System.out.println("YES");
            } else if (w == (x + y)) {
                System.out.println("YES");
            } else if (w == (y + z)) {
                System.out.println("YES");
            } else if (w == (x + z)) {
                System.out.println("YES");
            } else if (w == (x + y + z)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }

        scr.close();
    }
}
