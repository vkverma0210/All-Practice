import java.util.Scanner;

public class CheflandGames {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int[] x = new int[4];

            int flag = 0;
            for (int i = 0; i < 4; i++) {
                x[i] = scr.nextInt();

                if (x[i] == 1) {
                    flag = 1;
                }
            }

            if (flag == 1) {
                System.out.println("OUT");
            } else {
                System.out.println("IN");
            }

            t--;
        }

        scr.close();
    }
}