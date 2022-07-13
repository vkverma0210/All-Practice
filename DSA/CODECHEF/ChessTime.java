import java.util.Scanner;

public class ChessTime {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            n = n * 60;

            System.out.println(n / 20);

            t--;
        }
        scr.close();
    }
}
