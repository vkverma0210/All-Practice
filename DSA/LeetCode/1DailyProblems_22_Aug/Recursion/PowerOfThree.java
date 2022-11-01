import java.util.Scanner;

public class PowerOfThree {
    // 1. Nave Approach
    public static boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;

        while (n != 1) {
            int r = n % 3;
            n = n / 3;

            if (r != 0)
                return false;
        }

        return true;
    }

    // 2. Mathematics
    public static boolean isPowerOfThree1(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(isPowerOfThree(n));
        System.out.println(isPowerOfThree1(n));

        scr.close();
    }
}
