import java.util.Scanner;

public class Factorial {

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }

        int small_ans = fact(n - 1);
        return n * small_ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(fact(n));

        scr.close();
    }
}
