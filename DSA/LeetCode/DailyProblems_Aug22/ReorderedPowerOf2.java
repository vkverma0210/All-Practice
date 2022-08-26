import java.util.Arrays;
import java.util.Scanner;

public class ReorderedPowerOf2 {
    public static boolean reorderedPowerOf2(int n) {
        int[] countN = count(n);

        int num = 1;

        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(countN, count(num))) {
                return true;
            }

            num = num << 1;
        }

        return false;
    }

    public static int[] count(int n) {
        int[] arr = new int[10];

        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(reorderedPowerOf2(n));

        scr.close();
    }
}
