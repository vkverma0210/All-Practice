#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n, k;
    cin >> n >> k;

    int arr[n];
    int max = -1;

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];

        if (max < arr[i])
            max = arr[i];
    }

    long long lo = 0;
    long long hi = max;

    long long count = 0, mid;
    long long h = 0;

    while (lo <= hi)
    {
        mid = (lo + hi) / 2;
        count = 0;
        for (int i = 0; i < n; i++)
        {
            long long temp = arr[i] - mid;
            count += (temp > 0 ? temp : 0);
        }

        if (count == k)
        {
            h = mid;
            break;
        }
        else if (count < k)
        {
            hi = mid - 1;
        }
        else
            lo = mid + 1;

        if (mid > h)
            h = mid;
    }

    cout << h << endl;

    return 0;
}