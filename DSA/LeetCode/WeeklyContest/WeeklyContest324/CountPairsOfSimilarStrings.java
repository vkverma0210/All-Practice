import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountPairsOfSimilarStrings {
    public static int similarPairs(String[] words) {
        Set<Character> set = new HashSet<>();
        HashMap<String, Integer> hs = new HashMap<>();

        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }

            String temp = set.toString();
            hs.put(temp, hs.getOrDefault(temp, 0) + 1);
            set.clear();
        }

        int ans = 0;
        for (int val : hs.values()) {
            if (val > 1) {
                ans += val * (val - 1) / 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scr.next();
        }

        System.out.println(similarPairs(words));
        scr.close();
    }
}