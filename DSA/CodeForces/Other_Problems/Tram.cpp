#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int arr[n][2];
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            cin >> arr[i][j];
        }
    }

    int ans = 0;
    int capacity = 0;

    for (int i = 0; i < n; i++)
    {
        capacity -= arr[i][0];
        capacity += arr[i][1];

        if (ans < capacity)
            ans = capacity;
    }

    cout << ans << endl;

    return 0;
}