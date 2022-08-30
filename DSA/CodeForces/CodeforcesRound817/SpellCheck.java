import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class SpellCheck {
    public static void solve(String str) {
        if (str.length() > 5) {
            System.out.println("NO");
            return;
        }
        Set<Character> s = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            s.add(str.charAt(i));
        }

        char[] temp = { 'T', 'i', 'm', 'u', 'r' };

        for (int i = 0; i < 5; i++) {
            if (s.contains(temp[i]))
                s.remove(temp[i]);
        }

        if (s.size() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            String str = scr.next();

            solve(str);

            t--;
        }
        scr.close();
    }
}
