import java.util.Scanner;

public class RecursionFirstOccurenceLinearSearch {
    public static int linearSearch(int[] arr, int i, int key) {
        if (i == arr.length)
            return -1;

        if (arr[i] == key)
            return i;

        return linearSearch(arr, i + 1, key);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }

        int key = scr.nextInt();

        System.out.println(linearSearch(arr, 0, key));

        scr.close();
    }
}
