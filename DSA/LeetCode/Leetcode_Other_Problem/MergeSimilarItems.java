import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections;

public class MergeSimilarItems {
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ret = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] i : items1) {
            map.put(i[0], i[1]);
        }

        for (int[] i : items2) {
            if (map.containsKey(i[0])) {
                map.put(i[0], map.get(i[0]) + i[1]);
            } else {
                map.put(i[0], i[1]);
            }
        }

        for (int i : map.keySet()) {
            ArrayList<Integer> set = new ArrayList<>();
            set.add(i);
            set.add(map.get(i));
            ret.add(set);
        }

        Collections.sort(ret, (a, b) -> a.get(0) - b.get(0));

        return ret;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int m = scr.nextInt();

        int[][] items1 = new int[n][2];
        int[][] items2 = new int[m][2];

        for (int i = 0; i < n; i++) {
            items1[i][0] = scr.nextInt();
            items1[i][1] = scr.nextInt();
        }

        for (int i = 0; i < m; i++) {
            items2[i][0] = scr.nextInt();
            items2[i][1] = scr.nextInt();
        }

        List<List<Integer>> ans = mergeSimilarItems(items1, items2);

        System.out.println(ans);
        scr.close();
    }
}
