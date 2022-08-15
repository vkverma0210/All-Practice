import java.util.Scanner;

public class NodeWithHighestEdgeScore {
    public static int edgeScore(int[] edges) {
        int n = edges.length;

        int[] scoreOfNode = new int[n];

        for (int i = 0; i < n; i++) {
            scoreOfNode[edges[i]] += i;
        }

        int maxAnsIndex = 0;

        for (int i = 0; i < n; i++) {
            if (scoreOfNode[i] > scoreOfNode[maxAnsIndex])
                maxAnsIndex = i;
        }

        return maxAnsIndex;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int edges[] = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = scr.nextInt();
        }

        System.out.println(edgeScore(edges));

        scr.close();
    }
}
