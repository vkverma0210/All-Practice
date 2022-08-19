import java.util.Scanner;

public class FastPowerRecursion {
    public static int power(int a, int n) {
        if (n == 0)
            return 1;

        return a * power(a, n - 1);
    }

    public static int fast_power(int a, int n) {
        if (n == 0)
            return 1;

        int smaller_ans = fast_power(a, n / 2);
        smaller_ans *= smaller_ans;

        if (n % 2 != 0) {
            return smaller_ans * a;
        }

        return smaller_ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int a = scr.nextInt();
        int n = scr.nextInt();

        System.out.println(power(a, n));
        System.out.println(fast_power(a, n));
        scr.close();
    }
}
