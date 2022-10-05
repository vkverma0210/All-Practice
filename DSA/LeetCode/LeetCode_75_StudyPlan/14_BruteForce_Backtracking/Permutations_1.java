import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations_1 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums.length == 0) {
            return permutations;
        }

        permute_Helper(permutations, new ArrayList<>(), nums, 0);

        return permutations;
    }

    private static void permute_Helper(List<List<Integer>> permutations, List<Integer> curr, int[] nums, int start) {
        if (curr.size() == nums.length) {
            permutations.add(curr);
            return;
        }

        for (int i = 0; i <= curr.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(curr);
            newPermutation.add(i, nums[start]);
            permute_Helper(permutations, newPermutation, nums, start + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(permute(nums));
        scr.close();
    }
}
