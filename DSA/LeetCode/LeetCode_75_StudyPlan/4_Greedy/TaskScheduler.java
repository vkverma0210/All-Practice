import java.util.Scanner;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0, maxCount = 0;

        for (char task : tasks) {
            counter[task - 'A']++;

            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int l = scr.nextInt();
        char[] tasks = new char[l];

        for (int i = 0; i < l; i++) {
            tasks[i] = scr.next().charAt(0);
        }

        int n = scr.nextInt();

        System.out.println(leastInterval(tasks, n));
        scr.close();
    }
}
