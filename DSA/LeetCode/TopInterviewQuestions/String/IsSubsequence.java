import java.util.Scanner;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int n = s.length() - 1;
        int m = t.length() - 1;

        int i = 0, j = 0;

        while (i != n && j != m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if (i != n)
            return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        String t = scr.next();

        System.out.println(isSubsequence(s, t));

        scr.close();
    }
}
