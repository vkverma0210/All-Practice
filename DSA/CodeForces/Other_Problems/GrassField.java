import java.util.Scanner;

public class GrassField {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int count = 0;

            for (int i = 0; i < 4; i++) {
                int x = scr.nextInt();
                if (x == 1) {
                    count += 1;
                }
            }

            if (count == 0) {
                System.out.println(0);
            } else if (count == 1 || count == 2 || count == 3) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }

            t--;
        }
        scr.close();
    }
}
