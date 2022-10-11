import java.util.Scanner;

public class BitwiseXORofAllPairings {
    private static int xor(int[] nums) {
        int res = 0;

        for (int n : nums) {
            res ^= n;
        }

        return res;
    }

    public static int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n % 2 == 0 && m % 2 == 0) {
            return 0;
        }

        int xorArr1 = xor(nums1);
        int xorArr2 = xor(nums2);

        if (n % 2 == 1 && m % 2 == 1) {
            return xorArr1 ^ xorArr2;
        }

        if (n % 2 != 0) {
            return xorArr2;
        } else {
            return xorArr1;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums1 = new int[n];

        for (int i = 0; i < n; i++) {
            nums1[i] = scr.nextInt();
        }

        int m = scr.nextInt();
        int[] nums2 = new int[m];

        for (int i = 0; i < m; i++) {
            nums2[i] = scr.nextInt();
        }

        System.out.println(xorAllNums(nums1, nums2));

        scr.close();
    }
}
