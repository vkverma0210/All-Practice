import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.lang.Override;
import java.util.List;

public class ReduceArraySizetoTheHalf {
    public static int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int a : arr) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }

        int size = arr.length;

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int count = 0;
        for (Map.Entry<Integer, Integer> l : list) {
            size -= l.getValue();
            count++;

            if (size <= arr.length / 2)
                return count;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }

        System.out.println(minSetSize(arr));

        scr.close();
    }
}
