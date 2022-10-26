import java.util.Scanner;

public class XJumps {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();

            int quo = x / y;
            int rem = x % y;
            int ans = quo + rem;
            System.out.println(ans);

            t--;
        }

        scr.close();
    }
}
