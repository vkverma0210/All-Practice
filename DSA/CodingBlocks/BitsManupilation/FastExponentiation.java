import java.util.Scanner;

public class FastExponentiation {
    public static int power_optimised(int a, int n) {
        int ans = 1;
        while (n > 0) {
            int last_bit = (n & 1);
            if (last_bit == 1) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int a = scr.nextInt();
        int n = scr.nextInt();

        int ans = power_optimised(a, n);

        System.out.println(ans);

        scr.close();
    }
}
