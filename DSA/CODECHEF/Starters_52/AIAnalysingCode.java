import java.util.Scanner;

public class AIAnalysingCode {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        if (n <= 1000) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scr.close();
    }
}
