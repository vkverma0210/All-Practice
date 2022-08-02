import java.util.Scanner;

public class CountingSetBits {
    public static int countBits(int n) {
        int ans = 0;
        while (n > 0) {
            ans += (n & 1);
            n = n >> 1;
        }

        return ans;
    }

    public static int countBitsFast(int n) {
        int ans = 0;
        while (n > 0) {
            n = n & (n - 1);
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int ans = countBits(n);
        System.out.println(ans);

        int ans1 = countBits(n);
        System.out.println(ans1);

        System.out.println(Integer.bitCount(n));
        scr.close();
    }
}
