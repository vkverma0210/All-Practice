import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class PossibleBipartition {
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] dislikeArray = new List[n + 1];

        for (int i = 0; i < dislikeArray.length; i++) {
            dislikeArray[i] = new ArrayList<>();
        }

        for (int i = 0; i < dislikes.length; i++) {
            dislikeArray[dislikes[i][0]].add(dislikes[i][1]);
            dislikeArray[dislikes[i][1]].add(dislikes[i][0]);
        }

        int[] group = new int[n + 1];
        Arrays.fill(group, -1);
        for (int i = 1; i <= n; i++) {
            if (group[i] == -1 && !paint(group, i, dislikeArray, 0)) {
                return false;
            }
        }

        return true;
    }

    private static boolean paint(int[] group, int index, List<Integer> dislikeArray[], int colour) {
        group[index] = colour;
        for (int i = 0; i < dislikeArray[index].size(); i++) {
            int nextIndex = dislikeArray[index].get(i);

            if (group[nextIndex] == colour) {
                return false;
            }

            if (group[nextIndex] == -1 && !paint(group, nextIndex, dislikeArray, 1 - colour)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int k = scr.nextInt();
        int n = scr.nextInt();
        int[][] dislikes = new int[n][2];
        for (int i = 0; i < n; i++) {
            dislikes[i][0] = scr.nextInt();
            dislikes[i][1] = scr.nextInt();
        }

        System.out.println(possibleBipartition(k, dislikes));
        scr.close();
    }
}
