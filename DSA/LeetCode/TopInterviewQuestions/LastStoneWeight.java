import java.util.PriorityQueue;
import java.util.Scanner;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : stones)
            pq.offer(x);

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            pq.offer(x - y);
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] stones = new int[n];

        for (int i = 0; i < n; i++) {
            stones[i] = scr.nextInt();
        }

        System.out.println(lastStoneWeight(stones));

        scr.close();
    }
}
