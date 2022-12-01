import java.util.Set;
import java.util.Scanner;

public class DetermineIfStringHalvesAreAlike {
    private static int countVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                count++;
            }
        }

        return count;
    }

    public static boolean halvesAreAlike(String s) {
        int n = s.length();
        int count1 = countVowels(s.substring(0, n / 2));
        int count2 = countVowels(s.substring(n / 2, n));

        return count1 == count2;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String s = scr.next();
        System.out.println(halvesAreAlike(s));
        scr.close();
    }
}
