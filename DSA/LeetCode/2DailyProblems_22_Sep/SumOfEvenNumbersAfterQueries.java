import java.util.Scanner;

public class SumOfEvenNumbersAfterQueries {
    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];

        int sum = 0;

        for (int n : nums) {
            if (n % 2 == 0) {
                sum += n;
            }
        }

        int i = 0;
        for (int[] query : queries) {
            int index = query[1];
            int val = query[0];

            if (nums[index] % 2 == 0) {
                sum -= nums[index];
            }

            nums[index] += val;

            if (nums[index] % 2 == 0) {
                sum += nums[index];
            }

            ans[i++] = sum;
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

        int m = scr.nextInt();
        int[][] queries = new int[m][2];

        for (int i = 0; i < m; i++) {
            queries[i][0] = scr.nextInt();
            queries[i][1] = scr.nextInt();
        }

        int[] ans = sumEvenAfterQueries(nums, queries);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + " ");
        }

        System.out.println();
        scr.close();
    }
}
