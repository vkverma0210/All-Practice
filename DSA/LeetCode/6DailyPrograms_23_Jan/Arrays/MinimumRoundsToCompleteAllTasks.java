import java.util.Scanner;
import java.util.HashMap;

public class MinimumRoundsToCompleteAllTasks {
    public static int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> getCount = new HashMap<>();

        for (int task : tasks) {
            getCount.put(task, getCount.getOrDefault(task, 0) + 1);
        }

        int result = 0;

        for (int count : getCount.values()) {
            if (count == 1) {
                return -1;
            }

            result += count / 3;

            if (count % 3 != 0) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = scr.nextInt();
        }

        System.out.println(minimumRounds(tasks));
        scr.close();
    }
}
