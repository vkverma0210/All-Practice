import java.util.Arrays;
import java.util.Scanner;

public class TheNumberofWeakCharactersintheGame {
    public static int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        int count = 0;
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? (a[1] - b[1]) : (b[0] - a[0]));

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (properties[i][1] < max) {
                count++;
            }

            max = Math.max(max, properties[i][1]);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[][] properties = new int[n][2];

        for (int i = 0; i < n; i++) {
            properties[i][0] = scr.nextInt();
            properties[i][1] = scr.nextInt();
        }

        System.out.println(numberOfWeakCharacters(properties));

        scr.close();
    }
}
