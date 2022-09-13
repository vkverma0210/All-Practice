import java.util.Scanner;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] nums = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));

            if (s == g)
                bulls++;
            else {
                if (nums[s] < 0)
                    cows++;
                if (nums[g] > 0)
                    cows++;

                nums[s]++;
                nums[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String secret = scr.next();
        String guess = scr.next();

        System.out.println(getHint(secret, guess));

        scr.close();
    }
}
