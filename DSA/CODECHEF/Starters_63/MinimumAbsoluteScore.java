import java.util.Scanner;

public class MinimumAbsoluteScore {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String a = scr.next();
            String b = scr.next();
            int score = 0;

            for (int i = 0; i < n; i++) {
                if (a.charAt(i) > b.charAt(i)) {
                    int j = 26 - (a.charAt(i) - b.charAt(i));
                    score += j;
                } else {
                    int d = (b.charAt(i) - a.charAt(i);
                    score += d;
                }
            }

            System.out.println(Math.min( Math.abs(score % 26 - 26), score % 26);
            t--;
        }

        scr.close();
    }
}
