import java.util.Scanner;

public class GreaterAverage {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {

            float a = (float) scr.nextInt();
            float b = (float) scr.nextInt();
            float c = (float) scr.nextInt();
            if ((a + b) / 2 > c) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }

        scr.close();
    }
}
