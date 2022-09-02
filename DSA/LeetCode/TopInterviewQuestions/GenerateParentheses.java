import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        generateParenthesisHelper(ans, n, 0, 0, "");

        return ans;
    }

    private static void generateParenthesisHelper(List<String> ans, int n, int open, int close, String curr_str) {
        // base case
        if (curr_str.length() == n * 2) {
            ans.add(curr_str);
            return;
        }

        if (open < n)
            generateParenthesisHelper(ans, n, open + 1, close, curr_str + "(");

        if (close < open)
            generateParenthesisHelper(ans, n, open, close + 1, curr_str + ")");
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        List<String> res = generateParenthesis(n);

        for (String s : res) {
            System.out.println(s);
        }

        scr.close();
    }
}
