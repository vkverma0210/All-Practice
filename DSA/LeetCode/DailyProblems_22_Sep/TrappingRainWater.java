import java.util.Scanner;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int left = 0, leftMax = 0;
        int right = height.length - 1, rightMax = 0;
        int res = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }

                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }

                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = scr.nextInt();
        }

        System.out.println(trap(height));

        scr.close();
    }
}
