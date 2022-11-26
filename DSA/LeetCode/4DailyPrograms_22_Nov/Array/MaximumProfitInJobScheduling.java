import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
    private static class Job {
        private int startTime;
        private int endTime;
        private int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobList = new ArrayList<>();

        for (int i = 0; i < profit.length; i++) {
            jobList.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(jobList, (a, b) -> a.endTime - b.endTime);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);

        int ans = 0;

        for (Job currJob : jobList) {
            int lastEndTime = map.floorKey(currJob.startTime);
            int lastEndTimeMaxProfit = map.get(lastEndTime);
            ans = Math.max(ans, lastEndTimeMaxProfit + currJob.profit);
            map.put(currJob.endTime, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        int[] startTime = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = scr.nextInt();
        }

        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            endTime[i] = scr.nextInt();
        }

        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = scr.nextInt();
        }

        System.out.println(jobScheduling(startTime, endTime, profit));
        scr.close();
    }

}