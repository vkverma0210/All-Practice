import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class SortThePeople {
    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> sm = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < heights.length; i++) {
            sm.put(heights[i], names[i]);
        }

        String[] ans = new String[heights.length];
        int i = 0;
        for (Map.Entry<Integer, String> mapEntry : sm.entrySet()) {
            ans[i++] = mapEntry.getValue();
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        String[] names = new String[n];
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = scr.next();
        }

        for (int i = 0; i < n; i++) {
            heights[i] = scr.nextInt();
        }

        String[] res = sortPeople(names, heights);

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }

        System.out.println();
        scr.close();
    }
}
