import java.util.Scanner;

public class SmallestEvenMultiple {
    public static int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        } else {
            return n * 2;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(smallestEvenMultiple(n));

        scr.close();
    }
}
