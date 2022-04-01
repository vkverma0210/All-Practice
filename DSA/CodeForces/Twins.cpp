#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int arr[n];
    int sum = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        sum += arr[i];
    }

    sort(arr, arr + n, greater<int>());

    sum = sum / 2;

    int ans = 0;
    int count = 0;

    for (int i = 0; i < n; i++)
    {
        ans += arr[i];
        count++;

        if (ans > sum)
        {
            break;
        }
    }

    cout << count << "\n";

    return 0;
}