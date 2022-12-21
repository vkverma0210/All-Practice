import java.util.Scanner;

public class SpiceLevel {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            if (n < 4) {
                System.out.println("MILD");
            } else if (n >= 4 && n < 7) {
                System.out.println("MEDIUM");
            } else {
                System.out.println("HOT");
            }
            t--;
        }

        scr.close();
    }
}
