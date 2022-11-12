import java.util.HashMap;
import java.util.Scanner;

// 1. arr=2 2 3 3 out=2
// map 2-2 3-2

// 2. arr=2 2 2 3 3
// out=2

// 3. arr=2 2 3 3 5
// out=-1

// 4. arr=2 2 2 2 2 2
// out=2

public class Test {
    public static int solve(int n, int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        int count = 0;

        for (Integer val : hm.values()) {
            if (val < 2) {
                return -1;
            }

            if (val < 3) {
                count++;
            }

            int quo = val / 3;
            count += quo;
            int rem = val % 3;
            if (rem > 0 && val > 3) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 3, 2, 3 };
        int n = arr.length;

        System.out.println(solve(n, arr));
    }
}


cf1 - na cf2 - mark1 mark2
r1  na  mark1 mark2     
1, vinay , 23, 34  
2,ram,45,34
1, ram, 

idx1 1      cf1 idx1XXXX1XXXVinayXXXram

int2 2 cf2

class 