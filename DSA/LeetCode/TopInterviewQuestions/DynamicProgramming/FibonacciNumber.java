import java.util.Scanner;

public class FibonacciNumber {
    public static int fib_Iterative(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static int fib_Recursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int n1 = fib_Recursive(n - 1);
        int n2 = fib_Recursive(n - 2);

        return n1 + n2;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(fib_Iterative(n));
        System.out.println(fib_Recursive(n));
        scr.close();
    }
}
