import java.util.Scanner;

public class DifferentConsecutiveCharacters {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String str = scr.next();

            int count = 0;
            int i = 0, j = 1;

            while (j < n) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }

                i++;
                j++;
            }

            System.out.println(count);
            t--;
        }

        scr.close();
    }
}
