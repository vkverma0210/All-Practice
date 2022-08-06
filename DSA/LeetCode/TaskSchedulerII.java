import java.util.HashMap;
import java.util.Scanner;

public class TaskSchedulerII {
    public static long taskSchedulerII(int[] tasks, int spaces) {
        long res = 0;
        HashMap<Integer, Long> hm = new HashMap<>();

        for (int a : tasks) {
            if (hm.containsKey(a)) {
                hm.put(a, res = Math.max(res, hm.get(a) + spaces) + 1);
            } else {
                hm.put(a, ++res);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] tasks = new int[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = scr.nextInt();
        }

        int spaces = scr.nextInt();

        long ans = taskSchedulerII(tasks, spaces);

        System.out.println(ans);

        scr.close();
    }
}
