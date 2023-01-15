import java.util.Scanner; 
import java.util.Arrays;

public class NumberOfGoodPaths {
   private static int[] parent, count;
    private static int res;
    
    public static int numberOfGoodPaths(int[] vals, int[][] edges) {
        Arrays.sort(edges, (o1, o2) -> Integer.compare(Math.max(vals[o1[0]], vals[o1[1]]), Math.max(vals[o2[0]], vals[o2[1]])));
        int n = vals.length;
        res = n;
        parent = new int[n];
        count = new int[n];

        Arrays.fill(count, 1);

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int [] edge: edges){
            union(edge[0], edge[1], vals);
        }
        
        return res;
    }
    
    private static void union(int x, int y, int[] vals){
        int parx = find(x);
        int pary = find(y);

        if(parx == pary){
            return;
        }

        if(vals[parx] == vals[pary]){
            res += count[parx] * count[pary];
            count[parx] += count[pary];
            parent[pary] = parx;
        }else if(vals[parx] > vals[pary]){
            parent[pary] = parx;
        }
        else{
            parent[parx] = pary;
        }
    }

    private static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int [] vals = new int[n];
        for(int i = 0; i < n; i++){
            vals[i] = scr.nextInt();
        }
        
        int edge = scr.nextInt();
        int[][] edges = new int[edge][2];
        for (int i = 0; i < edge; i++) {
            edges[i][0] = scr.nextInt();
            edges[i][1] = scr.nextInt();
        }

        System.out.println(numberOfGoodPaths(vals, edges));
        scr.close();
    }
}
