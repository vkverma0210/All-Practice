import java.util.Scanner;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[]nums,int target){
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < n; i++){
            Integer requiredNumber = (Integer) (target - nums[i]);
            
            if(hm.containsKey(requiredNumber))
            {
                int ans[] = {hm.get(requiredNumber), i};
                return ans;
            }

            hm.put(nums[i], i);
        }

            return null;
    }
    
    
    public static void main(String[] args) {
    Scanner scr = new Scanner(System.in);

    int n = scr.nextInt();

    int[] nums = new int[n];

    for(int i = 0;i<n;i++)
    {
        nums[i] = scr.nextInt();
    }

    int target = scr.nextInt();

    int []ans = twoSum(nums,target);

    for(int i = 0; i < 2; i++){
        System.out.print(ans[i] + " ");
    }

    System.out.println();

        scr.close();        
    }
}
