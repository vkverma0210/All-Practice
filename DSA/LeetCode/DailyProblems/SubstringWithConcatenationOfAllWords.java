import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int n = words.length;
        int m = words[0].length();

        if (s.length() < m * n) {
            return ans;
        }

        for (int i = 0; i <= s.length() - (m * n); i++) {
            Map<String, Integer> mp = new HashMap<>();

            for (int j = 0; j < n; j++) {
                mp.put(words[j], mp.containsKey(words[j]) ? mp.get(words[j]) + 1 : 1);
            }

            int t;
            for (t = 0; t < n; t++) {
                String str = s.substring(i + t * m, i + t * m + m);

                if (mp.containsKey(str)) {
                    int count = mp.get(str);
                    if (count == 1)
                        mp.remove(str);
                    else
                        mp.put(str, count - 1);

                    if (mp.isEmpty()) {
                        ans.add(i);
                        break;
                    }
                } else
                    break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();

        int n = scr.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++)
            words[i] = scr.next();

        List<Integer> ans = findSubstring(s, words);

        for (Integer l : ans) {
            System.out.print(l + " ");
        }

        System.out.println();
        scr.close();
    }
}