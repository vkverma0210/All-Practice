import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        if (strs.length == 1) {
            result.add(Arrays.asList(strs));
            return result;
        }

        HashMap<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            String ordered = getOrder(s);
            groups.putIfAbsent(ordered, new ArrayList<>());
            groups.get(ordered).add(s);
        }

        return (new ArrayList<>(groups.values()));
    }

    private static String getOrder(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scr.next();
        }

        List<List<String>> ans = groupAnagrams(strs);
        for (List<String> list : ans) {
            for (String l : list) {
                System.out.print(l + " ");
            }

            System.out.println();
        }
        scr.close();
    }
}
