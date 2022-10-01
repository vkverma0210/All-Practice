import java.util.HashMap;
import java.util.Scanner;

public class RemoveLetterToEqualizeFrequency {
    public static boolean equalFrequency(String word) {
        HashMap<Character, Integer> hs = new HashMap<>();

        for (char c : word.toCharArray()) {
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer a : hs.values()) {
            min = Math.min(a, min);
            max = Math.max(a, max);
        }

        if ((max == min) &&(max - min) == 1) {
            return true;
        } else if ( {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        System.out.println(equalFrequency(s));

        scr.close();
    }

}