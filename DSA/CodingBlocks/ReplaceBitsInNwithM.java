import java.util.Scanner;

public class ReplaceBitsInNwithM {

    public static int clearBithsItoJ(int n, int i, int j) {
        int ones = ~0;
        int a = ones << (j + 1);
        int b = (i << i) - 1;

        int mask = a | b;
        int ans = n & mask;

        return ans;
    }

    public static int replaceBits(int n, int i, int j, int m) {
        int n_ = clearBithsItoJ(n, i, j);
        int ans = n_ | (m << i);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int i = scr.nextInt();
        int j = scr.nextInt();
        int m = scr.nextInt();

        int ans = replaceBits(n, i, j, m);

        System.out.println(ans);

        scr.close();

    }
}
