import java.util.Scanner;

public class YESorYES {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {
            String str = scr.next();

            String temp = str.toUpperCase();

            if (temp.equals("YES") == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }

        scr.close();
    }
}
