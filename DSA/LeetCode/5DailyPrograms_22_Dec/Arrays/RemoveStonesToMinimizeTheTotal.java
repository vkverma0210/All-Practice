import java.util.PriorityQueue;
import java.util.Scanner;

public class RemoveStonesToMinimizeTheTotal {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int pile : piles) {
            pq.add(pile);
        }

        while (k > 0 && !pq.isEmpty()) {
            int temp = pq.poll();
            temp -= (int) Math.floor(temp / 2);
            pq.add(temp);
            k--;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] piles = new int[n];
        for (int i = 0; i < n; i++) {
            piles[i] = scr.nextInt();
        }

        int k = scr.nextInt();

        System.out.println(minStoneSum(piles, k));
        scr.close();
    }
}
