import java.util.Scanner;

public class RoundDownThePrice {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {

            int m = scr.nextInt();

            int count = 0;

            int temp = m;

            while (temp != 0) {
                temp = temp / 10;
                count++;
            }

            double ans = m - Math.pow(10, (count - 1));

            System.out.println((int) ans);

            t--;
        }
        scr.close();
    }
}
