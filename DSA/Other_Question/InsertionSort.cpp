#include <bits/stdc++.h>

using namespace std;

void insertionSort(int arr[], int n)
{
    for (int i = 1; i <= n - 1; i++)
    {
        int e = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > e)
        {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = e;
    }
}

int main()
{
    int n;
    cin >> n;

    int arr[n];

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    insertionSort(arr, n);

    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;
}