public class ArraySorted {

    public static boolean isSorted(int arr[], int n) {
        if (n == 0 || n == 1)
            return true;

        if (arr[n - 1] > arr[n - 2] && isSorted(arr, n - 1)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 14, 119 };

        int n = arr.length;

        System.out.println(isSorted(arr, n));
    }
}
