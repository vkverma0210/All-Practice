import java.util.HashSet;
import java.util.Scanner;

public class CheckIfTheSentenceIsPangram {
    public static boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();

        for (Character ch : sentence.toCharArray()) {
            set.add(ch);
        }

        if (set.size() == 26) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        System.out.println(checkIfPangram(s));

        scr.close();
    }

}