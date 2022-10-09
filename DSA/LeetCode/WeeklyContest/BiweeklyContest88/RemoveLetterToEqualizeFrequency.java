import java.util.HashMap;
import java.util.Scanner;

public class RemoveLetterToEqualizeFrequency {
    public static boolean equalFrequency(String word) {
        int len = word.length();
        int[] count = new int[26];

        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            count[c - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            count[c - 'a']--;
            if (checkEqualCount(count)) {
                return true;
            }

            count[c - 'a']++;
        }

        return false;
    }

    private static boolean checkEqualCount(int[] count) {
        int c = 0;

        for (int i : count) {
            if (i == 0) {
                continue;
            } else if (c == 0) {
                c = i;
            } else if (c == i) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        System.out.println(equalFrequency(s));

        scr.close();
    }

}