import java.util.Scanner;

public class AvoidSquaresPlease {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            while (n > 0) {
                System.out.print(n + " ");
                n = n - 1;
            }
            System.out.println();
            t--;
        }

        scr.close();
    }
}
