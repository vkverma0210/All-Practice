import java.util.Scanner;

public class PalindromeFlipping {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String str = scr.next();

            int count0 = 0, count1 = 0;

            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }

            if (count0 % 2 == 0 && count1 % 2 == 0) {
                System.out.println("YES");
            } else if ((count0 % 2 == 0 && count1 % 2 == 1) || (count0 % 2 == 1 && count1 % 2 == 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }

        scr.close();
    }
}
