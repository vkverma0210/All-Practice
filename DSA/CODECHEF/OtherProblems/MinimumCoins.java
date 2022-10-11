import java.util.Scanner;

public class MinimumCoins {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            System.out.println(n % 10);

            t--;
        }
        scr.close();
    }
}
