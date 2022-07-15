import java.util.Scanner;

public class DecimalToBinary {
    public static int decimalToBinary(int n) {
        int ans = 0;
        int p = 1;
        while (n > 0) {
            int lastBits = n & 1;
            ans += p * lastBits;
            p = p * 10;
            n = n >> 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int ans = decimalToBinary(n);
        System.out.println(ans);

        scr.close();
    }
}
