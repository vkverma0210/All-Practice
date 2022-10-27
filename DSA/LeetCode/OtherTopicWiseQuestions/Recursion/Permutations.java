import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void collectPermutations(int[] nums, int start, List<Integer> permutation,
            List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(permutation);
            return;
        }

        for (int i = 0; i <= permutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(i, nums[start]);
            collectPermutations(nums, start + 1, newPermutation, permutations);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        if (nums.length == 0)
            return permutations;

        collectPermutations(nums, 0, new ArrayList<>(), permutations);
        return permutations;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        List<List<Integer>> ans = permute(nums);

        System.out.println(ans);

        scr.close();
    }
}
