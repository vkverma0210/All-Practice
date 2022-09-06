import java.util.Scanner;

public class StrictlyPalindromicNumber {
    public static boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            if (baseCalculate(n, i) == false)
                return false;
        }

        return true;
    }

    public static boolean baseCalculate(int n, int base) {
        long sum = 0;
        int digit = 1;
        while (n > 0) {
            long res = n % base;
            sum = sum + res * digit;
            n /= 10;
            digit *= 10;
        }

        return isPalindrome(sum);
    }

    public static boolean isPalindrome(long n) {
        String s = Long.toString(n);
        StringBuilder sb = new StringBuilder(s);

        String rev = sb.reverse().toString();

        if (rev == s) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(isStrictlyPalindromic(n));

        scr.close();
    }
}
