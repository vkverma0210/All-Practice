import java.util.Scanner;

public class Dec21 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();

            System.out.println(y - x);
            t--;
        }

        scr.close();
    }
}
