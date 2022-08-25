import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!hm.containsKey(c) || hm.get(c) < 1) {
                return false;
            }

            hm.put(c, hm.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String ransomNote = scr.next();
        String magazine = scr.next();

        System.out.println(canConstruct(ransomNote, magazine));

        scr.close();
    }
}
