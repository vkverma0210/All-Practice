import java.util.Scanner;

public class OddPairs {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {

            long n = scr.nextLong();

            if (n % 2 == 0) {
                System.out.println((n / 2) * n);
            } else {
                System.out.println(((n - 1) / 2) * (n + 1));
            }

            t--;
        }

        scr.close();
    }
}
