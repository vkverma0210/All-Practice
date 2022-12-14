import java.util.Scanner;

public class ScaleneTriangle {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int a = scr.nextInt();
            int b = scr.nextInt();
            int c = scr.nextInt();

            if (a != b && b != c && a != c) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            t--;
        }

        scr.close();
    }
}
