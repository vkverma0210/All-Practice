import java.util.Scanner;

public class BinaryBattles {
    public static int solve(int n, int a, int b) {
        int count = 0;
        while (n != 0) {
            n = n / 2;
            count++;
        }
        count--;

        int ans = (count * a) + ((count - 1) * b);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int a = scr.nextInt();
            int b = scr.nextInt();

            System.out.println(solve(n, a, b));
            t--;
        }

        scr.close();
    }
}
