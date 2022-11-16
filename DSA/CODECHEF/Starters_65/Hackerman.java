import java.util.Scanner;

public class Hackerman {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int a = scr.nextInt();
            int b = scr.nextInt();

            int ans = a + b;

            if (ans == 2 || ans == 3 || ans == 5 || ans == 7 || ans == 11) {
                System.out.println("ALICE");
            } else {
                System.out.println("BOB");
            }
            t--;
        }

        scr.close();
    }
}
