import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(items1);
        Arrays.sort(items2);
        int size1 = items1.length;
        int size2 = items2.length;
        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            if (items[i][0] == items2[j][0]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(items[i][1] + items2[j][1]);
                ret.add(items1[i][0], temp);
                i++;
                j++;
            } else if (items[i][0] < items2[j][0]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(items[i][1]);
                ret.add(items1[i][0], temp);
                i++;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(items[j][1]);
                ret.add(items1[j][0], temp);
                j++;
            }

            while (i < size1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(items[i][1]);
                ret.add(items1[i][0], temp);
                i++;
            }

            while (i < size1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(items[j][1]);
                ret.add(items1[j][0], temp);
                j++;
            }
        }

        return ret;
    }
}
