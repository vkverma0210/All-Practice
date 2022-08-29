import java.sql.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import javafx.util.Pair;

public class FindTheK_SumOfAnArray {
    public static long kSum(int[] nums, int k) {
        long sum = 0;
        Queue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Long.compare(b.getKey(), a.getKey()));

        for (int i = 0; i < nums.length; i++) {
            sum = sum + Math.max(0, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        long result = sum;

        pq.offer(new Pair<>(sum - nums[0], 0));

        while (--k > 0) {
            Pair<Long, Integer> pair = pq.poll();
            result = pair.getKey();
            int index = pair.getValue();

            if (index < nums.length - 1) {
                pq.offer(new Pair<>(result + nums[index] - nums[index + 1], index + 1));
                pq.offer(new Pair<>(result - nums[index + 1], index + 1));

            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int k = scr.nextInt();

        System.out.println(kSum(nums, k));

        scr.close();
    }
}
