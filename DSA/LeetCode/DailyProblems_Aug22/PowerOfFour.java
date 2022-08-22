import java.util.Scanner;

public class PowerOfFour {
    public static boolean isPowerOfFour(int n) {
        if (n == 0)
            return false;

        if (n == 1)
            return true;

        if (n % 4 != 0)
            return false;

        return isPowerOfFour(n / 4);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(isPowerOfFour(n));

        scr.close();
    }
}
