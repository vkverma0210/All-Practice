import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class WordLadderII {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Set<String>> reverse = new HashMap<>();

        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> nextLevel = new HashSet<>();
        boolean findEnd = false;

        while (!queue.isEmpty()) {
            String word = queue.remove();

            for (String next : wordSet) {
                if (isLadder(word, next)) {
                    Set<String> reverseLadders = reverse.computeIfAbsent(next, k -> new HashSet<>());
                    reverseLadders.add(word);

                    if (endWord.equals(next)) {
                        findEnd = true;
                    }

                    nextLevel.add(next);
                }
            }

            if (queue.isEmpty()) {
                if (findEnd)
                    break;

                queue.addAll(nextLevel);
                wordSet.removeAll(nextLevel);
                nextLevel.clear();
            }
        }

        if (!findEnd)
            return ans;

        Set<String> path = new LinkedHashSet<>();
        path.add(endWord);
        findPath(endWord, beginWord, reverse, ans, path);
        return ans;
    }

    private static void findPath(String endWord, String beginWord, Map<String, Set<String>> graph,
            List<List<String>> ans, Set<String> path) {
        Set<String> next = graph.get(endWord);

        if (next == null)
            return;

        for (String word : next) {
            path.add(word);

            if (beginWord.equals(word)) {
                List<String> shortestPath = new ArrayList<>(path);
                Collections.reverse(shortestPath);
                ans.add(shortestPath);
            } else {
                findPath(word, beginWord, graph, ans, path);
            }

            path.remove(word);
        }
    }

    private static boolean isLadder(String s, String t) {
        if (s.length() != t.length())
            return false;

        int diffCount = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                diffCount++;

            if (diffCount > 1)
                return false;
        }

        return diffCount == 1;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String beginWord = scr.next();
        String endWord = scr.next();

        int n = scr.nextInt();

        List<String> wordList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String temp = scr.next();
            wordList.add(temp);
        }

        List<List<String>> ans = findLadders(beginWord, endWord, wordList);

        // for (List<String> str : ans) {
        // for (String s : str) {
        // System.out.print(s + " ");
        // }

        // System.out.println();
        // }

        System.out.println(ans);

        scr.close();
    }
}
