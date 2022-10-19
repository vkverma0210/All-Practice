import java.util.Scanner;

public class SqrtOfx {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int start = 1, end = x;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int x = scr.nextInt();

        System.out.println(mySqrt(x));

        scr.close();
    }
}
