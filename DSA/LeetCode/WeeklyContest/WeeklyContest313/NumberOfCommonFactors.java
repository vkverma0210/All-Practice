import java.util.Scanner;

public class NumberOfCommonFactors {
    public static int commonFactors(int a, int b) {
        int count = 1;
        if (b < a) {
            int temp = b;
            b = a;
            a = temp;
        }

        for (int i = 2; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int a = scr.nextInt();
        int b = scr.nextInt();

        System.out.println(commonFactors(a, b));
        scr.close();
    }
}
