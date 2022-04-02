#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int arr[n][2];
    int ans = 0;

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i][0];
        cin >> arr[i][1];
    }

    for (int i = 0; i < n; i++)
    {
        if ((arr[i][0] + 2) <= arr[i][1])
            ans++;
    }

    cout << ans << "\n";

    return 0;
}