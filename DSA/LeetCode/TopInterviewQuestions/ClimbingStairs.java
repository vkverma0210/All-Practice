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

    private static long fac(int a){
        long ans = 1;

        for(int i = 1; i <=a; i++){
            ans = ans * i;
        } 

        return ans;
    }

    public static int climbStairs_Srajan(int n) {
        int x  = n / 2;
        int sum = 0;

        if(n % 2 == 0){
            for(int i = 0; i < x; i++){
                sum += ((long)fac(x + i)/((long)fac(x - i) * (long)fac(2 * i)));
            }
        } else{
            for(int i = 0; i < x; i++){
                sum += (fac(x + 1 + i)/(fac(x - i) * fac(2 * i  + 1)));
            }
        }

        return sum + 1;
    }
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        System.out.println(climbStairs(n));
        System.out.println(climbStairs_Srajan(n));

        scr.close();
    }
}
