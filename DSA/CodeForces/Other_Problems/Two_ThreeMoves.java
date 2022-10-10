import java.util.Scanner;

public class Two_ThreeMoves {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            if (n == 1) {
                System.out.println(2);
            } else if (n % 3 == 0) {
                System.out.println(n / 3);
            } else {
                System.out.println(n / 3 + 1);
            }

            t--;
        }
        scr.close();
    }
}
