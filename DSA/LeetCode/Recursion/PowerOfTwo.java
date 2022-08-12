import java.util.Scanner;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;
        else if (n == 0 || n % 2 != 0)
            return false;

        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(isPowerOfTwo(n));

        scr.close();
    }
}
