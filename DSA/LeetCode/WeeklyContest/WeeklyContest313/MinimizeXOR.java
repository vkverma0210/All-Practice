import java.util.Scanner;

public class MinimizeXOR {
    public static int minimizeXor(int num1, int num2) {
        int a = Integer.bitCount(num1), b = Integer.bitCount(num2), res = num1;

        for (int i = 0; i < 32; i++) {
            if (a > b && ((1 << i) & num1) > 0) {
                res ^= 1 << i;
                a--;
            }

            if (a < b && ((1 << i) & num1) == 0) {
                res ^= 1 << i;
                a++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int num1 = scr.nextInt();
        int num2 = scr.nextInt();

        System.out.println(minimizeXor(num1, num2));
        scr.close();
    }
}
