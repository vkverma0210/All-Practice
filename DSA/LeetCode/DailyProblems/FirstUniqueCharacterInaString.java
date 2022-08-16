import java.util.LinkedHashMap;
import java.util.Scanner;

public class FirstUniqueCharacterInaString {
    public static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> mp = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (mp.containsKey(s.charAt(i))) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
            } else {
                mp.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (mp.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String str = scr.next();

        System.out.println(firstUniqChar(str));

        scr.close();
    }
}
