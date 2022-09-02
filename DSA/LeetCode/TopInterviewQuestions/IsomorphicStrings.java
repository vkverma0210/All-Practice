import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1)
            return true;

        HashMap<Character, Character> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (hm.containsKey(a)) {
                if (hm.get(a).equals(b))
                    continue;
                else
                    return false;
            } else {
                if (!hm.containsValue(b))
                    hm.put(a, b);
                else
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        String t = scr.next();

        System.out.println(isIsomorphic(s, t));

        scr.close();
    }
}
