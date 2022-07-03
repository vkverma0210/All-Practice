import java.util.Scanner;

class HighAccuracy {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();

            int r = x % 3;

            if (r == 0) {
                System.out.println(0);
            } else {
                System.out.println(3 - r);
            }

            t--;
        }
        scr.close();
    }
}
