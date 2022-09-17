import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class PalindromePairs {
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        // Empty String case
        if (map.containsKey("")) {
            int blankIdx = map.get("");

            for (int i = 0; i < words.length; i++) {
                if (i != blankIdx && isPalindrome(words[i])) {
                    res.add(Arrays.asList(blankIdx, i));
                    res.add(Arrays.asList(i, blankIdx));
                }
            }
        }

        // Reflection Case
        for (int i = 0; i < words.length; i++) {
            String reversed = new StringBuilder(words[i]).reverse().toString();
            Integer reversedIdx = map.get(reversed);
            if (reversedIdx != null && reversedIdx != i) {
                res.add(Arrays.asList(i, reversedIdx));
            }
        }

        // Tricky Case
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];

            for (int cut = 1; cut < curr.length(); cut++) {
                String left = curr.substring(0, cut);
                String right = curr.substring(cut);

                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();

                    if (map.containsKey(reversedRight)) {
                        res.add(Arrays.asList(map.get(reversedRight), i));
                    }
                }

                if (isPalindrome(right)) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reversedLeft)) {
                        res.add(Arrays.asList(i, map.get(reversedLeft)));
                    }
                }
            }
        }

        return res;
    }

    private static boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;

        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scr.next();
        }

        List<List<Integer>> res = palindromePairs(words);

        System.out.println(res);

        scr.close();
    }
}
