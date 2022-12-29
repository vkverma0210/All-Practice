import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Task {
    int start, time, idx;

    public Task(int start, int time, int idx) {
        this.start = start;
        this.time = time;
        this.idx = idx;
    }
}

public class SingleThreadedCPU {
    public static int[] getOrder(int[][] tasks) {
        int currTime = 0, i2 = 0, n = tasks.length;
        int[] order = new int[n];

        PriorityQueue<Task> orderedTasks = new PriorityQueue<>(Comparator.comparingInt(t -> t.start));
        for (int i = 0; i < n; i++) {
            orderedTasks.add(new Task(tasks[i][0], tasks[i][1], i));
        }

        PriorityQueue<Task> processor = new PriorityQueue<>(
                (t1, t2) -> t1.time == t2.time ? Integer.compare(t1.idx, t2.idx) : Integer.compare(t1.time, t2.time));

        while (!orderedTasks.isEmpty()) {
            while (!orderedTasks.isEmpty() && orderedTasks.peek().start <= currTime) {
                processor.add(orderedTasks.poll());
            }

            if (!processor.isEmpty()) {
                Task task = processor.poll();
                order[i2++] = task.idx;
                currTime += task.time;
            } else {
                if (!orderedTasks.isEmpty()) {
                    currTime = orderedTasks.peek().start;
                } else {
                    break;
                }
            }
        }

        while (!processor.isEmpty()) {
            order[i2++] = processor.poll().idx;
        }

        return order;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = scr.nextInt();
            tasks[i][1] = scr.nextInt();
        }

        int[] ans = getOrder(tasks);

        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
        scr.close();
    }
}