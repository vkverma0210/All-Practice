#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n, h;
    cin >> n >> h;

    int arr[n];
    int ans = 0;

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        if (arr[i] > h)
            ans += 2;
        else
            ans += 1;
    }

    cout << ans << "\n";

    return 0;
}