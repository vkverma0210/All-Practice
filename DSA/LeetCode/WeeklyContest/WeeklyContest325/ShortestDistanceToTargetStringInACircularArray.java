import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ShortestDistanceToTargetStringInACircularArray {
    public static int closetTarget(String[] words, String target, int startIndex) {
        HashMap<String, List<Integer>> hs = new HashMap<>();

        int i = 0;
        for (String str : words) {
            if (!hs.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hs.put(str, list);
            } else {
                List<Integer> list = hs.get(str);
                list.add(i);
            }

            i += 1;
        }
        int ans = Integer.MAX_VALUE;
        if (!hs.containsKey(target)) {
            return -1;
        } else {
            List<Integer> list = hs.get(target);
            for (Integer ls : list) {
                if (ls > startIndex) {
                    int val1 = ls - startIndex;
                    int val2 = words.length - (ls - startIndex);
                    ans = Math.min(ans, Math.min(val1, val2));
                } else {
                    int val1 = startIndex - ls;
                    int val2 = words.length - (startIndex - ls);
                    ans = Math.min(ans, Math.min(val1, val2));
                }
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

        String target = scr.next();
        int startIndex = scr.nextInt();
        System.out.println(closetTarget(words, target, startIndex));
        scr.close();
    }
}
