import java.util.Scanner;

public class IncreasingDecreasingNumber {
    public static void dec(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        dec(n - 1);
    }

    public static void inc(int n) {
        if (n == 0) {
            return;
        }

        inc(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        dec(n);
        System.out.println();
        inc(n);

        scr.close();
    }
}
