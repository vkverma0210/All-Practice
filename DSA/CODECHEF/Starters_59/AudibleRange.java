import java.util.Scanner;

public class AudibleRange {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            if (n >= 67 && n <= 45000) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }

        scr.close();
    }
}
