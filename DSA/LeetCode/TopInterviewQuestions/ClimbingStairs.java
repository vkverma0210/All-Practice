import java.util.Scanner;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n <= 2)
        return n;

        int current_step =2;
        int previous_step = 1;

        for(int i = 3; i <= n; i++){
            int temp = current_step + previous_step;
            previous_step =  current_step; 
            current_step = temp;
        }
        
        return current_step;
    }
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        System.out.println(climbStairs(n));

        scr.close();
    }
}
