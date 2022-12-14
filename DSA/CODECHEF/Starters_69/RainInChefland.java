import java.util.Scanner;

public class RainInChefland {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            if (n < 3) {
                System.out.println("LIGHT");
            } else if (n >= 3 && n < 7) {
                System.out.println("MODERATE");
            } else {
                System.out.println("HEAVY");
            }
            t--;
        }

        scr.close();
    }
}