import java.util.Scanner;

public class SatisfiabilityOfEqualityEquations {
    static int[] unionFind = new int[26];

    private static int find(int x) {
        if (x != unionFind[x]) {
            unionFind[x] = find(unionFind[x]);
        }

        return unionFind[x];
    }

    public static boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            unionFind[i] = i;
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                unionFind[find(eq.charAt(0) - 'a')] = find(eq.charAt(3) - 'a');
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!' && find(eq.charAt(0) - 'a') == find(eq.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        String[] equations = new String[n];

        for (int i = 0; i < n; i++) {
            equations[i] = scr.next();
        }

        System.out.println(equationsPossible(equations));
        scr.close();
    }
}
