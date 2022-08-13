public class BinarySearch {
    public static int bianrySearch(int arr[], int start, int end, int k) {
        int mid = start + (end - start) / 2;

        if (start > end)
            return -1;

        if (arr[mid] == k)
            return mid;
        else if (arr[mid] < k)
            return bianrySearch(arr, mid + 1, end, k);
        else
            return bianrySearch(arr, start, mid - 1, k);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 14, 119 };

        int n = arr.length;

        int k = 2;

        System.out.println(bianrySearch(arr, 0, n - 1, k));
    }
}
