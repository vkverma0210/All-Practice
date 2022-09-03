import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersWithSameConsecutiveDifferences {
    private static void dfs(int num, int N, int K, List<Integer> result) {
        if (N == 0) {
            result.add(num);
            return;
        }

        int last_digit = num % 10;
        if (last_digit >= K)
            dfs(num * 10 + last_digit - K, N - 1, K, result);

        if (K > 0 && last_digit + K < 10)
            dfs(num * 10 + last_digit + K, N - 1, K, result);
    }

    public static int[] numsSameConsecDiff(int n, int K) {
        List<Integer> result = new ArrayList<>();

        if (n == 1)
            result.add(0);

        for (int d = 1; d < 10; d++)
            dfs(d, n - 1, K, result);

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int k = scr.nextInt();

        int[] res = numsSameConsecDiff(n, k);

        for (int x : res) {
            System.out.println(x);
        }

        scr.close();
    }
}
