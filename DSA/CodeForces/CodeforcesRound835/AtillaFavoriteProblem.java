import java.util.Scanner;

public class AtillaFavoriteProblem {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String str = scr.next();

            int maxi = 0;

            for (int i = 0; i < n; i++) {
                int temp = str.charAt(i) - 'a' + 1;
                maxi = Math.max(maxi, temp);
            }

            System.out.println(maxi);
            t--;
        }

        scr.close();
    }
}
