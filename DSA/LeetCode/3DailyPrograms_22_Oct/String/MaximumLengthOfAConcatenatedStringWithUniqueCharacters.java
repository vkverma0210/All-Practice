import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    static int max = 0;

    public static int maxLength(List<String> arr) {
        maxLengthHelper(arr, "", 0);
        return max;
    }

    private static void maxLengthHelper(List<String> arr, String current, int start) {
        if (max < current.length()) {
            max = current.length();
        }

        for (int i = start; i < arr.size(); i++) {
            if (!isValid(current, arr.get(i))) {
                continue;
            }

            maxLengthHelper(arr, current + arr.get(i), i + 1);
        }
    }

    private static boolean isValid(String currentString, String newString) {
        int[] arr = new int[26];

        for (int i = 0; i < newString.length(); i++) {
            arr[newString.charAt(i) - 'a']++;
            if (arr[newString.charAt(i) - 'a'] == 2) {
                return false;
            }

            if (currentString.contains(newString.charAt(i) + "")) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        List<String> arr = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String s = scr.next();
            arr.add(s);
        }

        System.out.println(maxLength(arr));

        scr.close();
    }
}