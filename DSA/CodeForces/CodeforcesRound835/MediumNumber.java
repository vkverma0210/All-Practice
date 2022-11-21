import java.util.Scanner;

public class MediumNumber {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int a = scr.nextInt();
            int b = scr.nextInt();
            int c = scr.nextInt();

            int ans;

            if (a >= b && a >= c) {
                if (b >= c) {
                    System.out.println(b);
                } else {
                    System.out.println(c);
                }
            } else if (b >= a && b >= c) {
                if (a >= c) {
                    System.out.println(a);
                } else {
                    System.out.println(c);
                }
            } else if (c >= a && c >= a) {
                if (a >= b) {
                    System.out.println(a);
                } else {
                    System.out.println(b);
                }
            }

            t--;
        }

        scr.close();
    }
}
