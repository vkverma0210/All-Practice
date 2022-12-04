import java.util.Arrays;
import java.util.Scanner;

public class DividePlayersIntoTeamsOfEqualSkill {
    public static long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        int i = 1, j = n - 2;
        int prev = skill[0] + skill[n - 1];
        long ans = skill[0] * skill[n - 1];
        while (i < j) {
            int curr = skill[i] + skill[j];
            if (curr != prev) {
                return (long) (-1);
            }

            ans += skill[i] * skill[j];
            i++;
            j--;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(dividePlayers(nums));
        scr.close();
    }
}
