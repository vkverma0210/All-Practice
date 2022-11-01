import java.util.Scanner;

public class PushDominoes {
    private static void solveConfiguration(char[] arr, int i, int j) {
        if (arr[i] == 'L' && arr[j] == 'L') {
            for (int k = i + 1; k < j; k++) {
                arr[k] = 'L';
            }
        } else if (arr[i] == 'R' && arr[j] == 'R') {
            for (int k = i + 1; k < j; k++) {
                arr[k] = 'R';
            }
        } else if (arr[i] == 'L' && arr[j] == 'R') {

        } else {
            int diff = j - i;
            int mid = (i + j) / 2;
            if (diff % 2 == 0) {
                // odd case
                for (int k = i + 1; k < mid; k++) {
                    arr[k] = 'R';
                }

                for (int k = mid + 1; k < j; k++) {
                    arr[k] = 'L';
                }
            } else {
                // Even Case
                for (int k = i + 1; k <= mid; k++) {
                    arr[k] = 'R';
                }

                for (int k = mid + 1; k < j; k++) {
                    arr[k] = 'L';
                }
            }
        }
    }

    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = new char[n + 2];
        arr[0] = 'L';
        arr[n + 1] = 'R';

        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = dominoes.charAt(i - 1);
        }

        int j = 0;
        int k = 1;

        while (k < arr.length) {
            while (arr[k] == '.') {
                k++;
            }

            if (k - j > 1) {
                solveConfiguration(arr, j, k);
            }

            j = k;
            k++;
        }

        // String res = "";
        // for (int i = 1; i < arr.length - 1; i++) {
        // res += arr[i];
        // }

        StringBuilder res = new StringBuilder();
        for (int i = 1; i < arr.length - 1; i++) {
            res.append(arr[i]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String dominoes = scr.next();

        System.out.println(pushDominoes(dominoes));
        scr.close();
    }
}
