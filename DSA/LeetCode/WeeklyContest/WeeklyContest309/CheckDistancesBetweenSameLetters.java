import java.util.HashMap;
import java.util.Scanner;

public class CheckDistancesBetweenSameLetters {
    public static boolean checkDistances(String s, int[] distance) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), i + 1);
            } else {
                if (distance[s.charAt(i) - 'a'] != i - hm.get(s.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();

        int[] distance = new int[26];
        for (int i = 0; i < 26; i++) {
            distance[i] = scr.nextInt();
        }

        System.out.println(checkDistances(s, distance));

        scr.close();
    }
}
