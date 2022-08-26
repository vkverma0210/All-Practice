import java.util.Scanner;

public class MinimumHoursOfTrainingToWinaCompetition {
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (initialEnergy > energy[i]) {
                initialEnergy -= energy[i];
            } else {
                ans += (energy[i] - initialEnergy + 1);
                initialEnergy += (energy[i] - initialEnergy + 1);
                initialEnergy -= energy[i];
                System.out.println(initialEnergy + " Energy");
            }

            if (initialExperience > experience[i]) {
                initialExperience += experience[i];
            } else {
                ans += (experience[i] - initialExperience + 1);
                initialExperience += (experience[i] - initialExperience) + 1;
                initialExperience += experience[i];
                System.out.println(initialExperience + " experience");
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int initialEnergy = scr.nextInt();
        int initialExperience = scr.nextInt();

        int n = scr.nextInt();

        int[] energy = new int[n];

        for (int i = 0; i < n; i++) {
            energy[i] = scr.nextInt();
        }

        int[] experience = new int[n];

        for (int i = 0; i < n; i++) {
            experience[i] = scr.nextInt();
        }

        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));

        scr.close();
    }
}
