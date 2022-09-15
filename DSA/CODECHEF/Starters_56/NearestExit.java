import java.util.Scanner;

public class NearestExit {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();

            if (x <= 50) {
                System.out.println("LEFT");
            } else {
                System.out.println("RIGHT");
            }

            t--;
        }

        scr.close();
    }
}
