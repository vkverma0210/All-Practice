import java.util.Scanner;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int majorityEle = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                majorityEle = nums[i];
            } else if (majorityEle == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return majorityEle;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(majorityElement(nums));

        scr.close();
    }
}
