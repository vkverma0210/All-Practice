import java.util.Scanner;

public class RecursionLastOccurenceLinearSearch {
    public static int lastOccurance(int[] arr, int idx, int key) {
        if (idx == arr.length)
            return -1;

        int ans = lastOccurance(arr, idx + 1, key);

        if (ans == -1) {
            if (arr[idx] == key)
                return idx;
            else
                return -1;

        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }

        int key = scr.nextInt();

        System.out.println(lastOccurance(arr, 0, key));

        scr.close();
    }
}
