import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null) {
            return ans;
        }

        ans.add(new ArrayList<>());
        for (int n : nums) {
            int size = ans.size();

            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(ans.get(i));
                temp.add(n);
                ans.add(temp);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        List<List<Integer>> ans = subsets(nums);

        System.out.println(ans);

        scr.close();
    }
}
