import java.util.Scanner;

public class NearestCourt {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();

            int distance = Math.abs(x - y);

            if (distance % 2 == 0) {
                System.out.println(distance / 2);
            } else {
                System.out.println(distance / 2 + 1);
            }

            t--;
        }
        scr.close();
    }
}
