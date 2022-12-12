import java.util.Scanner;

public class ClimbingStairs1 {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int currentStep = 2;
        int previousStep = 1;

        for (int i = 3; i <= n; i++) {
            int temp = currentStep + previousStep;
            previousStep = currentStep;
            currentStep = temp;
        }

        return currentStep;
    }
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
    
        System.out.println(climbStairs( n));
        scr.close();
    }
}