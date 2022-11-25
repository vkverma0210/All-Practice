import java.util.Scanner;
import java.util.Stack;

public class SumOfSubarrayMinimums {
    public static int sumSubarrayMins(int[] arr) {
        long mod = (long) 1000000007;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i <= arr.length; i++) {
            int currVal = (i <= arr.length - 1) ? arr[i] : 0;

            while (stack.peek() != -1 && currVal < arr[stack.peek()]) {
                int index = stack.pop();
                int j = stack.peek();
                int left = index - j;
                int right = i - index;
                long add = (left * right * (long) arr[index]) % mod;
                ans += add;
                ans %= mod;
            }

            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }

        System.out.println(sumSubarrayMins(arr));
        scr.close();
    }
}
