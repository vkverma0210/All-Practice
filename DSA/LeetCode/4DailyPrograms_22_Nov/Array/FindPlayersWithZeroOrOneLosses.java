import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FindPlayersWithZeroOrOneLosses {
    public static List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(matches[i][0]))
                map.put(matches[i][0], 0);

            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> won = new ArrayList<>();
        List<Integer> lost = new ArrayList<>();

        for (int key : map.keySet()) {
            if (map.get(key) == 0) {
                won.add(key);
            }

            if (map.get(key) == 1) {
                lost.add(key);
            }
        }

        Collections.sort(won);
        Collections.sort(lost);
        ans.add(won);
        ans.add(lost);

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[][] matches = new int[n][2];
        for (int i = 0; i < n; i++) {
            matches[i][0] = scr.nextInt();
            matches[i][1] = scr.nextInt();
        }

        List<List<Integer>> ans = findWinners(matches);

        for (List<Integer> a : ans) {
            for (int x : a) {
                System.out.print(x + " ");
            }

            System.out.println();
        }

        scr.close();
    }
}