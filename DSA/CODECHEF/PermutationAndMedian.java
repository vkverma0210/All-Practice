import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

class PermutationAndMedian {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            int arr[] = new int[n];

            if (n == 1) {
                System.out.println(1);
            } else if (n == 2) {
                System.out.println(2 + " " + 1);
            } else {
                int k = 0;

                for (int j = 0; j < n; j = j + 2) {
                    arr[j] = n - k;
                    k++;
                }

                int m = 1;

                for (int j = 1; j < n; j = j + 2) {
                    arr[j] = m;
                    m++;
                }

                for (int j = 0; j < n; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
            t--;
        }
        scr.close();
    }
}
