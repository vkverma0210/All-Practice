import java.util.Scanner;
public class MinimumNumberOfOnes {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            System.out.println(n / 2);
            t--;
        }

        scr.close();
    }
}
