import java.util.Scanner;

public class PrintAllOccurenceOfKey {
    public static void allOccurance(int[] arr, int idx, int key) {
        if (idx == arr.length)
            return;

        if (arr[idx] == key)
            System.out.println(idx);

        allOccurance(arr, idx + 1, key);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }

        int key = scr.nextInt();

        allOccurance(arr, 0, key);

        scr.close();
    }
}
