import java.util.Scanner;

public class ChefOnDate {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();

            if (x >= y) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }
        scr.close();
    }
}