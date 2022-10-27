import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LongestPalindrome {
    public static int longestPalindrome_HashMap(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        boolean odd_found = false;

        for (int c : counts.values()) {
            if (c % 2 == 0)
                result += c;
            else {
                odd_found = true;
                result += c - 1;
            }
        }

        if (odd_found)
            result++;

        return result;
    }

    public static int longestPalindrome_HashSet(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashSet<Character> hs = new HashSet<>();

        int count = 0;

        for (char c : s.toCharArray()) {
            if (hs.contains(c)) {
                hs.remove(c);
                count++;
            } else {
                hs.add(c);
            }
        }

        if (!hs.isEmpty())
            return count * 2 + 1;

        return count * 2;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();

        System.out.println(longestPalindrome_HashMap(s));
        System.out.println(longestPalindrome_HashSet(s));

        scr.close();
    }
}
