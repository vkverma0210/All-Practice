import java.util.Scanner;

class EnoughSpace {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int x = scr.nextInt();
            int y = scr.nextInt();

            if (x + y * 2 <= n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }
        scr.close();
    }
}