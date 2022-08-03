import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            System.out.println(100 - n);

            t--;
        }
        scr.close();
    }
}
