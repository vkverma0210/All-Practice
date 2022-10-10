#include <bits/stdc++.h>

using namespace std;

long solve(int n, long arr[])
{
    int count = 0;

    for (int i = n - 2; i >= 0; i--)
    {
        if (arr[1] == 1)
        {
            while (arr[0] != 1)
            {
                arr[i] = arr[i] / 2;
                count++;
            }

            arr[0] = 0;
            count++;
            return count;
        }

        if (arr[i] >= arr[i + 1])
        {
            while ((arr[i] >= arr[i + 1]) && (arr[i] != 1 && arr[i + 1] != 1))
            {
                arr[i] = arr[i] / 2;
                count++;
            }
        }

        if (arr[i] >= arr[i + 1])
        {
            count = -1;
            return count;
        }
    }

    return count;
}

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        int n;
        cin >> n;

        long arr[n];
        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
        }

        long ans = solve(n, arr);

        cout << ans << "\n";
    }

    return 0;
}