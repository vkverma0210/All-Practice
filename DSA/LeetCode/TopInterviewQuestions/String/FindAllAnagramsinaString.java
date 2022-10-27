import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindAllAnagramsinaString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();

        if (s.length() < p.length())
            return ls;

        int[] arr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            String temp = s.substring(i, p.length() + i);

            int[] arr1 = new int[26];
            for (int j = 0; j < p.length(); j++) {
                arr1[temp.charAt(j) - 'a']++;
            }

            if (Arrays.equals(arr, arr1))
                ls.add(i);
        }

        return ls;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        String p = scr.next();

        List<Integer> ans = findAnagrams(s, p);

        for (int a : ans) {
            System.out.print(a + " ");
        }

        System.out.println();

        scr.close();
    }
}
