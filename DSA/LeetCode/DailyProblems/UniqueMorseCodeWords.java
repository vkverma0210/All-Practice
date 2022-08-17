import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.lang.StringBuilder;

public class UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] code = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.." };

        HashSet<String> s = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                temp = temp.append(code[(words[i].charAt(j) - 'a')]);
            }

            s.add(temp.toString());
        }

        // System.out.println(s);

        return s.size();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = scr.next();
        }

        System.out.println(uniqueMorseRepresentations(str));

        scr.close();
    }
}
