import java.util.Scanner;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public static int concatenatedBinary(int n) {
        final long modulo = (long) (1e9 + 7);
        long result = 0;
        int binaryDigits = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                binaryDigits++;
            }

            result = ((result << binaryDigits) + i) % modulo;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(concatenatedBinary(n));
        scr.close();
    }
}
