#include <bits/stdc++.h>

using namespace std;

void printSumK(int arr[], int n, int k)
{
    int i = 0;
    int j = n - 1;

    while (i < j)
    {
        int curr_sum = arr[i] + arr[j];

        if (curr_sum > k)
            j--;
        else if (curr_sum < k)
            i++;
        else if (curr_sum == k)
        {
            cout << arr[i] << " and " << arr[j] << endl;
            i++;
            j--;
        }
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

    int k;
    cin >> k;

    printSumK(arr, n, k);
}