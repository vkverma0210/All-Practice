#include <bits/stdc++.h>

using namespace std;

int findMaxAverage(int arr[], int n, int k)
{
    if (k > n)
        return -1;

    int sum = arr[0];

    for (int i = 1; i < k; i++)
    {
        sum += arr[i];
    }

    int maxsum = sum, maxend = k - 1;

    for (int i = k; i < n; i++)
    {
        int sum = sum + arr[i] - arr[i - k];

        if (sum > maxsum)
        {
            maxsum = sum;
            maxend = i;
        }
    }

    return maxend - k + 1;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, k;
        cin >> k >> n;

        int arr[n];
        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
        }

        auto ans = findMaxAverage(arr, n, k);

        for (int i = ans; i < ans + k; i++)
        {
            cout << arr[i] << " ";
        }

        cout << "\n";
    }

    return 0;
}