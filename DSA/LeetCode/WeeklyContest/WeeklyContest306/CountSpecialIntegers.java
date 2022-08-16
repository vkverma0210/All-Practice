import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CountSpecialIntegers {
    public static int countSpecialNumbers(int n) {
        // 1. Convert n into digit arraylist
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }

        // 2. Case 1: for number length < nums.length
        int ret = 0;
        for (int len = 1; len < nums.size(); len++) {
            // get result
            // first choice 1 - 9
            int curr = 9;

            // second choice: 0 - 9 && non-first
            for (int slot = 0, choice = 9; slot < len - 1; slot++, choice--) {
                curr *= choice;
            }

            ret += curr;
            // System.out.println(ret);
        }

        // 2. Case 2: for number same length as nums
        Collections.reverse(nums);

        // for each digit: if smaller than old number, all other batch add if same as
        // old number, continue to next pos

        boolean[] visited = new boolean[10];
        for (int i = 0; i < nums.size(); i++) {
            // first digit cannot be 0
            // case: smaller than old number

            for (int j = i == 0 ? 1 : 0; j < nums.get(i); j++) {
                // skip if current value is used
                if (visited[j])
                    continue;

                // checkout remaining part
                int curr = 1;

                for (int slot = 0, choice = 9 - i; slot < nums.size() - i - 1; slot++, choice--) {
                    curr *= choice;
                }

                System.out.println("i : " + i + " curr: " + curr);
                ret += curr;
            }

            // Case: same, check if we can put nums[i] into current slot
            if (visited[nums.get(i)])
                break;

            visited[nums.get(i)] = true;
        }

        // edge case:if n itself is distinct or not, if it is distinct, ret++
        Set<Integer> set = new HashSet<>(nums);
        if (set.size() == nums.size())
            ret++;

        return ret;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(countSpecialNumbers(n));

        scr.close();
    }
}
