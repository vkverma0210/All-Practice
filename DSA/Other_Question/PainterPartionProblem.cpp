#include <bits/stdc++.h>

using namespace std;

int getMax(int arr[], int n)
{
    int ans = INT_MIN;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] > ans)
            ans = arr[i];
    }

    return ans;
}

int getSum(int arr[], int n)
{
    int sum = 0;

    for (int i = 0; i < n; i++)
        sum += arr[i];

    return sum;
}

int numberOfPainter(int arr[], int n, int maxlen)
{
    int total = 0;
    int numPainter = 1;

    for (int i = 0; i < n; i++)
    {
        total += arr[i];
        if (total > maxlen)
        {
            total = arr[i];
            numPainter++;
        }
    }

    return numPainter;
}

int partition(int arr[], int n, int k)
{
    int lo = getMax(arr, n);
    int hi = getSum(arr, n);

    while (lo < hi)
    {
        int mid = lo + (hi - lo) / 2;

        int requiredPainter = numberOfPainter(arr, n, mid);
        if (requiredPainter <= k)
            hi = mid;
        else
            lo = mid + 1;
    }

    return lo;
}

int main()
{
    int k;
    cin >> k;
    int n;
    cin >> n;

    int arr[n];

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    cout << partition(arr, n, k) << endl;

    return 0;
}