import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BinaryTreesWithFactors {
    public static int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer, Long> map = new HashMap<>();
        long res = 0L, mod = (long) 1e9 + 7;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    map.put(arr[i], (map.get(arr[i]) + map.get(arr[j]) * map.getOrDefault(arr[i] / arr[j], 0L)) % mod);
                }
            }

            res = (res + map.get(arr[i])) % mod;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }

        int ans = numFactoredBinaryTrees(arr);

        System.out.println(ans);

        scr.close();
    }
}
