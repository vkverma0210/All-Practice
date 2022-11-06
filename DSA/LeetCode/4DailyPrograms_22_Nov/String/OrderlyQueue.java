import java.util.Arrays;
import java.util.Scanner;

public class OrderlyQueue {
    public static String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            return new String(tempArray);
        } else {
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                s = s.substring(1) + s.substring(0, 1);
                System.out.println("S = " + s);
                if (ans.compareTo(s) > 0) {
                    ans = s;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        int k = scr.nextInt();

        System.out.println(orderlyQueue(s, k));

        scr.close();
    }
}
