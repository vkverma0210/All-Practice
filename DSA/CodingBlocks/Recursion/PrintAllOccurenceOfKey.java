import java.util.Scanner;

public class PrintAllOccurenceOfKey {
    public static int out[] = new int[100];

    public static int storeOcc(int[] arr, int i, int key, int j) {
        if (i == arr.length)
            return j;

        if (arr[i] == key) {
            out[j] = i;
            return storeOcc(arr, i + 1, key, j + 1);
        }

        return storeOcc(arr, i + 1, key, j);
    }

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

        // allOccurance(arr, 0, key);

        int x = storeOcc(arr, 0, key, 0);
        System.out.println(x);

        for (int i = 0; i < x; i++) {
            System.out.print(out[i] + " ");
        }

        System.out.println();
        scr.close();
    }
}
