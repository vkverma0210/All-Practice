import java.util.Scanner;
import java.util.*; 

public class MaximumPerformanceOfaTeam {
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];

        for(int i = 0 ; i < n; i++){
            arr[i] = new int[]{efficiency[i], speed[i]};
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<> (k, (a, b) -> a - b);
        long res = 0, sum = 0;

        for(int [] a : arr){
            pq.add(a[1]);
            sum = (sum + a[1]);

            if(pq.size() > k)
                sum -= pq.poll();
            
            res = Math.max(res, (sum * a[0]));
        }

        return (int)(res % (long)(1e9 + 7));
    }
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] speed = new int[n];

        for(int i = 0; i < n; i++){
            speed[i] = scr.nextInt();
        }

        int[] efficiency = new int[n];

        for(int i = 0; i < n; i++){
            efficiency[i] = scr.nextInt();
        }

        int k = scr.nextInt();

        System.out.println(maxPerformance(n, speed, efficiency, k));
        scr.close();
    }
}
