import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum_Helper(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private static void combinationSum_Helper(List<List<Integer>> result, List<Integer> curr, int[] candidates,
            int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                curr.add(candidates[i]);
                combinationSum_Helper(result, curr, candidates, target - candidates[i], i);
                curr.remove(curr.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<Integer>(curr));
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] candidates = new int[n];
        int target = scr.nextInt();

        for (int i = 0; i < n; i++) {
            candidates[i] = scr.nextInt();
        }

        System.out.println(combinationSum(candidates, target));
        scr.close();
    }
}
