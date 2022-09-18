import java.util.Scanner;

public class SmallestSubarraysWithMaximumBitwiseOR {
    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int now = 0;

        for (int i = n - 1; i >= 0; i--) {
            now |= nums[i];
            max[i] = now;
        }

        int[] bit = new int[31];
        int right = 0;
        now = 0;

        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            while (right < n && now < max[i]) {
                for (int j = 0; j < 31; j++) {
                    if ((nums[right] >> j) % 2 == 1) {
                        bit[j]++;

                        if (bit[j] == 1) {
                            now += (1 << j);
                        }
                    }
                }

                right++;
            }

            cnt[i] = Math.max(1, right - i);

            for (int j = 0; j < 31; j++) {
                if ((nums[i] >> j) % 2 == 1) {
                    bit[j]--;

                    if (bit[j] == 0) {
                        now -= (1 << j);
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        int[] ans = smallestSubarrays(nums);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

        scr.close();
    }
}
