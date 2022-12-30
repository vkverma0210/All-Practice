import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllPathsFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph.length == 0 || graph[0].length == 0) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, res, list, 0);
        return res;
    }

    private void dfs(int[][] graph, List<List<Integer>> res, List<Integer> list, int pos) {
        if (pos == graph.length - 1) {
            res.add(new ArrayList<>(list));
        } else {
            for (int d : graph[pos]) {
                list.add(d);
                dfs(graph, res, list, d);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
    }
}