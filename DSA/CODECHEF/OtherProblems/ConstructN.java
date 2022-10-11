import java.util.Scanner;

public class ConstructN {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            long n = scr.nextLong();

            while (n >= 7) {
                n = n % 7;
            }
            while (n >= 2) {
                n = n % 2;
            }

            if (n == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }
        scr.close();
    }
}
