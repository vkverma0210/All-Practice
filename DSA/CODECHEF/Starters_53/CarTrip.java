import java.util.Scanner;

public class CarTrip {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {

            int a = scr.nextInt();

            if (a >= 300) {
                System.out.println(a * 10);
            } else {
                System.out.println(3000);
            }

            t--;
        }

        scr.close();
    }
}
