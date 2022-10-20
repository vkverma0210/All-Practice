import java.util.Scanner;

public class OddSumPair {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();
            int z = scr.nextInt();

            int a1 = x + y;
            int a2 = y + z;
            int a3 = x + z;

            if (a1 % 2 != 0 || a2 % 2 != 0 || a3 % 2 != 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }

        scr.close();
    }
}
