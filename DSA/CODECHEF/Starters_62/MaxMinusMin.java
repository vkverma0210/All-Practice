import java.util.Scanner;

public class MaxMinusMin {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int a = scr.nextInt();
            int b = scr.nextInt();
            int c = scr.nextInt();

            System.out.println(c - a);
            t--;
        }

        scr.close();
    }
}
