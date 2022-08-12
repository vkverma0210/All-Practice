import java.util.Scanner;

public class FibonacciSeries {

    public static int fab(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int n1 = fab(n - 1);
        int n2 = fab(n - 2);

        return n1 + n2;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(fab(n));
        scr.close();
    }
}
