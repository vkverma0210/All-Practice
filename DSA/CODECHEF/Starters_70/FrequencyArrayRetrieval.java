import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class FrequencyArrayRetrieval {
    private static int[] solve(int n, int[] arr) {
        HashMap<Integer, List<Integer>> freq = new HashMap<>();
        int nextNum = 1;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (freq.containsKey(arr[i])) {
                if (freq.get(arr[i]).get(1) > 0) {
                    ans.add(freq.get(arr[i]).get(0));
                    List<Integer> temp = new ArrayList<>();
                    temp.add(freq.get(arr[i]).get(0));
                    temp.add(freq.get(arr[i]).get(1) - 1);
                    freq.put(arr[i], temp);

                    if (freq.get(arr[i]).get(1) == 0) {
                        freq.remove(arr[i]);
                    }
                }
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nextNum);
                temp.add(arr[i] - 1);
                freq.put(arr[i], temp);
                if (freq.get(arr[i]).get(1) == 0) {
                    freq.remove(arr[i]);
                }

                ans.add(nextNum);
                nextNum++;
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : freq.entrySet()) {
            if (entry.getValue().get(1) > 0) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scr.nextInt();
            }

            int[] ans = solve(n, arr);
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }

            System.out.println();

            t--;
        }

        scr.close();
    }
}
