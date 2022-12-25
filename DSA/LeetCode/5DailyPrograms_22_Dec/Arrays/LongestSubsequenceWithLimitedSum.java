import java.util.Scanner;
import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    public static int[] answerQueries(int[]nums,int[]queries){
        int n = nums.length;
        int m=queries.length;

        int [] ans = new int[m];

        Arrays.sort(nums);

        for(int i = 1; i < n;i++){
            nums[i] += nums[i - 1];
        }

        for(int i = 0; i< m; i++){
            int ind = Arrays.binarySearch(nums, queries[i]);
            ans[i] = Math.abs(ind + 1);
        }

        return ans;
    }
            
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int m = scr.nextInt();
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = scr.nextInt();
        }

        int[] ans = answerQueries(nums, queries);
    
        for(int a: ans){
            System.out.print(a + " ");
        }
        
        System.out.println();
    
        scr.close();
    }
}
