import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        Set<Integer> hs = new HashSet<>();

        for (int a : arr) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }

        for (int val : hm.values()) {
            hs.add(val);
        }

        return hm.size() == hs.size();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }

        System.out.println(uniqueOccurrences(arr));
        scr.close();
    }
}