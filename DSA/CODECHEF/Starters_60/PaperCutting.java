import java.util.Scanner;

public class PaperCutting {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();

            int a = x / y;

            System.out.println(a * a);
            t--;
        }

        scr.close();
    }
}
